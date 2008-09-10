grammar SnortFactory;

@lexer::header {
   package rsc.backend.modules.ips.backend.parser;
}

@header {
  package rsc.backend.modules.ips.backend.parser;

  import rsc.backend.modules.ips.backend.*;
  
  import java.io.InputStream;
  import java.util.Map;
  import java.util.TreeMap;
  import java.util.Vector;
}


@members {
    private Snortconf ret;

    public static Snortconf createInstance(InputStream is) throws Exception {
        SnortFactoryLexer lex = new SnortFactoryLexer(new ANTLRInputStream(is));
       	CommonTokenStream tokens = new CommonTokenStream(lex);

        SnortFactoryParser parser = new SnortFactoryParser(tokens);

        try {
            parser.snort();
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }
        
        return null;
    }
}

snort 
scope {
	Snortconf conf;
}
@init {
	$snort::conf=new Snortconf();
}
@after {
	System.out.println("---done---\n"+$snort::conf);
	ret=$snort::conf;
}
	:	(c=comment { $snort::conf.addComment($c.text); }
	|	cc=command { $snort::conf.add($cc.result); }
	|	e=empty { $snort::conf.addComment(); } )+;

comment	:	COMMENT ~('\n')* (NEWLINE|EOF);

empty	:	NEWLINE;

command	returns [Command result]
	:	r=rule { $result=$r.result; }
	|	c=config { $result=$c.result; }
	|	p=preprocessor { $result=$p.result; }
	|	o=output { $result=$o.result; }
	|	i=include { $result=$i.result; }
	|	v=var { $result=$v.result; }
	|	iv=ipvar { $result=$iv.result; }
	|	pv=portvar { $result=$pv.result; };
	
var returns [Command result]
	:	VAR na=VARNAME opts=untilnl { $result=new Var($na.text,$opts.text); };
	
ipvar returns [Command result]
	:	IPVAR na=VARNAME a=address { $result=new AddressVar($na.text,$a.result); };
	
portvar returns [Command result]
	:	PORTVAR na=VARNAME p=port { $result=new PortVar($na.text,$p.result); };
	
include	returns [Command result]
	:	INCLUDE file=untilnl
	{ 
		$result=new Include($file.text); 
	};

config returns [Command result]
	:	CONFIG na=VARNAME COLON opts=untilnl
	{
		$result=new Config($na.text,$opts.text);
	}
	|	CONFIG na=VARNAME
	{
		$result=new Config($na.text);
	};

preprocessor returns [Command result]
	:	PREPRO na=VARNAME COLON opts=untilnl
	{
		$result=new Preprocessor($na.text,$opts.text);
	}
	|	PREPRO na=VARNAME
	{
		$result=new Preprocessor($na.text);
	};
	
output returns [Command result]
	:	OUTPUT na=VARNAME COLON opts=untilnl
	{
		$result=new Output($na.text,$opts.text);
	}
	|	OUTPUT na=VARNAME
	{
		$result=new Output($na.text);
	};

rule returns [Command result]
	:	r=RULES adr1=vaddress port1=vport '->' adr2=vaddress port2=vport LB opts=untilrb RB
	{ 	
		$result=new Rule($r.text,$adr1.result,$port1.result,$adr2.result,$port2.result,$opts.text);
		//System.out.println("new Rule("+$r.text+", "+$adr1.result.toString()+","+$port1.result.toString()+","+$adr2.result.toString()+","+$port2.result.toString()+","+$opts.text+");");
	};

vaddress returns [AddressList result]
	:	a=address { $result=$a.result; }
	|	na=VARNAME { $result=$snort::conf.getAddressVar($na.text).getAddresses(); };
	
vport returns [PortList result]
	:	p=port { $result=$p.result; }
	|	na=VARNAME { $result=$snort::conf.getPortVar($na.text).getPorts(); };

address	returns [AddressList result]
	:	a=adr { $result=$a.result; }
	|	NEG SLB al=addressl SRB
	{
		$result=$al.result; 
		$result.setNegator(true);
	}
	|	SLB al=addressl SRB
	{
		$result=$al.result;
	};
	
addressl returns [AddressList result]
	:	a=adr COMMA al=addressl
	{
		$a.result.add($al.result);
		$result=$a.result;
	}
	|	aa=adr { $result=$aa.result; };

adr returns [AddressList result]	
	:	a=ADDRESS { $result=new AddressList(new Address(false,$a.text)); }
//	|	a=ADDRESS s=SUB { $result=new AddressList(new Address(false, $a.text,$s.text)); }
	|	NEG a=ADDRESS	{ $result=new AddressList(new Address(true, $a.text)); };
//	|	NEG a=ADDRESS s=SUB { $result=new AddressList(new Address(true,$a.text,$s.text)); };

SUB	:	SLASH NUMBER;

ADDRESS	:	NUMBER DOT NUMBER DOT NUMBER DOT NUMBER (SUB)?;

port returns [PortList result]
	:	p=pt { $result=$p.result; }
	|	n=NEG? SLB pl=portl SRB
	{
		$result=$pl.result;
		if($n!=null) {
			$result.setNegator(true);
		}
	};

portl returns [PortList result]
	:	p=pt (',' pl=portl)? 
	{
		$result=$p.result;
		if($pl.result!=null) {
			$result.addAll($pl.result);
		}
	};

pt returns [PortList result]
	:	n=NEG? p=NUMBER
	{
		$result=new PortList(new Port(($n!=null?true:false),$p.text));
	};
	
untilnl	:	~('\n')+;

untilrb	:	~(')')+;

//untilrb
//	:	(SYMBOL | LETTER | DIGIT | COMMENT | COLON | SLASH | NEG | SLB | SRB | LB | DOT | COMMA )+;

//untilnl
//	:	(~'\n' | SYMBOL | LETTER | DIGIT | COMMENT | COLON | SLASH | NEG | SLB | SRB | LB | RB | DOT | COMMA)+;

NEWLINE	:	'\n';
	
VAR	:	'var';

IPVAR	:	'ipvar';

PORTVAR	:	'portvar';
	
INCLUDE	:	'include';
	
OUTPUT	:	'output';
	
CONFIG	:	'config';

PREPRO	:	'preprocessor';

RULES	:	'alert' | 'log' | 'pass' | 'activate' | 'dynamic' | 'drop' | 'reject' | 'sdrop' /* | (a..z)+ */;

SYMBOL	:	'<' | '>' | '{' | '}' | '*' | '&' | '%' | '$' | '@' | '~' | '`' | '\'' | '\"' | '^' | '=' | '+' | '-' | ';' | '_';

COMMENT :	'#';

COLON	:	':';

SLASH	:	'/';

DIGIT	
	:	'0'..'9' ;

NEG	:	'!';

SLB	:	'[';

SRB	:	']';

LB	:	'(';

RB	:	')';

DOT	:	'.';

COMMA	:	',';

LETTER
	:	LOWER | UPPER;

fragment LOWER
	:	'a'..'z';

fragment UPPER
	:	'A'..'Z';
	
WHITESPACE
	:	( '\t' | ' ' | '\r' | '\\\n'| '\u000C' )+ { $channel=HIDDEN; };
	
VARNAME	:	LETTER (LETTER | DIGIT | '_')*;

VARREF	:	'$' LETTER (LETTER | DIGIT | '_')*;

NUMBER	:	DIGIT+;