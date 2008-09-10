// $ANTLR 3.1 src/rsc/backend/modules/ips/backend/parser/SnortFactory.g 2008-09-08 17:59:49

  package rsc.backend.modules.ips.backend.parser;

  import rsc.backend.modules.ips.backend.*;
  
  import java.io.InputStream;
  import java.util.Map;
  import java.util.TreeMap;
  import java.util.Vector;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SnortFactoryParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "NEWLINE", "VAR", "VARNAME", "IPVAR", "PORTVAR", "INCLUDE", "CONFIG", "COLON", "PREPRO", "OUTPUT", "RULES", "LB", "RB", "NEG", "SLB", "SRB", "COMMA", "ADDRESS", "SLASH", "NUMBER", "SUB", "DOT", "SYMBOL", "DIGIT", "LOWER", "UPPER", "LETTER", "WHITESPACE", "VARREF", "'->'"
    };
    public static final int SYMBOL=27;
    public static final int RB=17;
    public static final int SRB=20;
    public static final int LETTER=31;
    public static final int SLB=19;
    public static final int NUMBER=24;
    public static final int WHITESPACE=32;
    public static final int SUB=25;
    public static final int PREPRO=13;
    public static final int PORTVAR=9;
    public static final int EOF=-1;
    public static final int VARNAME=7;
    public static final int COLON=12;
    public static final int CONFIG=11;
    public static final int SLASH=23;
    public static final int T__34=34;
    public static final int NEWLINE=5;
    public static final int ADDRESS=22;
    public static final int COMMA=21;
    public static final int INCLUDE=10;
    public static final int NEG=18;
    public static final int VARREF=33;
    public static final int LB=16;
    public static final int VAR=6;
    public static final int LOWER=29;
    public static final int DIGIT=28;
    public static final int DOT=26;
    public static final int COMMENT=4;
    public static final int OUTPUT=14;
    public static final int UPPER=30;
    public static final int IPVAR=8;
    public static final int RULES=15;

    // delegates
    // delegators


        public SnortFactoryParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SnortFactoryParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return SnortFactoryParser.tokenNames; }
    public String getGrammarFileName() { return "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g"; }


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


    protected static class snort_scope {
        Snortconf conf;
    }
    protected Stack snort_stack = new Stack();


    // $ANTLR start "snort"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:38:1: snort : (c= comment | cc= command | e= empty )+ ;
    public final void snort() throws RecognitionException {
        snort_stack.push(new snort_scope());
        SnortFactoryParser.comment_return c = null;

        Command cc = null;



        	((snort_scope)snort_stack.peek()).conf =new Snortconf();

        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:49:2: ( (c= comment | cc= command | e= empty )+ )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:49:4: (c= comment | cc= command | e= empty )+
            {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:49:4: (c= comment | cc= command | e= empty )+
            int cnt1=0;
            loop1:
            do {
                int alt1=4;
                switch ( input.LA(1) ) {
                case COMMENT:
                    {
                    alt1=1;
                    }
                    break;
                case VAR:
                case IPVAR:
                case PORTVAR:
                case INCLUDE:
                case CONFIG:
                case PREPRO:
                case OUTPUT:
                case RULES:
                    {
                    alt1=2;
                    }
                    break;
                case NEWLINE:
                    {
                    alt1=3;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:49:5: c= comment
            	    {
            	    pushFollow(FOLLOW_comment_in_snort51);
            	    c=comment();

            	    state._fsp--;

            	     ((snort_scope)snort_stack.peek()).conf.addComment((c!=null?input.toString(c.start,c.stop):null)); 

            	    }
            	    break;
            	case 2 :
            	    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:50:4: cc= command
            	    {
            	    pushFollow(FOLLOW_command_in_snort60);
            	    cc=command();

            	    state._fsp--;

            	     ((snort_scope)snort_stack.peek()).conf.add(cc); 

            	    }
            	    break;
            	case 3 :
            	    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:51:4: e= empty
            	    {
            	    pushFollow(FOLLOW_empty_in_snort69);
            	    empty();

            	    state._fsp--;

            	     ((snort_scope)snort_stack.peek()).conf.addComment(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }


            	System.out.println("---done---\n"+((snort_scope)snort_stack.peek()).conf);
            	ret=((snort_scope)snort_stack.peek()).conf;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            snort_stack.pop();
        }
        return ;
    }
    // $ANTLR end "snort"

    public static class comment_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "comment"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:53:1: comment : COMMENT (~ ( '\\n' ) )* ( NEWLINE | EOF ) ;
    public final SnortFactoryParser.comment_return comment() throws RecognitionException {
        SnortFactoryParser.comment_return retval = new SnortFactoryParser.comment_return();
        retval.start = input.LT(1);

        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:53:9: ( COMMENT (~ ( '\\n' ) )* ( NEWLINE | EOF ) )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:53:11: COMMENT (~ ( '\\n' ) )* ( NEWLINE | EOF )
            {
            match(input,COMMENT,FOLLOW_COMMENT_in_comment82); 
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:53:19: (~ ( '\\n' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==COMMENT||(LA2_0>=VAR && LA2_0<=34)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:53:19: ~ ( '\\n' )
            	    {
            	    if ( input.LA(1)==COMMENT||(input.LA(1)>=VAR && input.LA(1)<=34) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            if ( input.LA(1)==EOF||input.LA(1)==NEWLINE ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comment"


    // $ANTLR start "empty"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:55:1: empty : NEWLINE ;
    public final void empty() throws RecognitionException {
        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:55:7: ( NEWLINE )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:55:9: NEWLINE
            {
            match(input,NEWLINE,FOLLOW_NEWLINE_in_empty102); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "empty"


    // $ANTLR start "command"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:57:1: command returns [Command result] : (r= rule | c= config | p= preprocessor | o= output | i= include | v= var | iv= ipvar | pv= portvar );
    public final Command command() throws RecognitionException {
        Command result = null;

        Command r = null;

        Command c = null;

        Command p = null;

        Command o = null;

        Command i = null;

        Command v = null;

        Command iv = null;

        Command pv = null;


        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:58:2: (r= rule | c= config | p= preprocessor | o= output | i= include | v= var | iv= ipvar | pv= portvar )
            int alt3=8;
            switch ( input.LA(1) ) {
            case RULES:
                {
                alt3=1;
                }
                break;
            case CONFIG:
                {
                alt3=2;
                }
                break;
            case PREPRO:
                {
                alt3=3;
                }
                break;
            case OUTPUT:
                {
                alt3=4;
                }
                break;
            case INCLUDE:
                {
                alt3=5;
                }
                break;
            case VAR:
                {
                alt3=6;
                }
                break;
            case IPVAR:
                {
                alt3=7;
                }
                break;
            case PORTVAR:
                {
                alt3=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:58:4: r= rule
                    {
                    pushFollow(FOLLOW_rule_in_command117);
                    r=rule();

                    state._fsp--;

                     result =r; 

                    }
                    break;
                case 2 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:59:4: c= config
                    {
                    pushFollow(FOLLOW_config_in_command126);
                    c=config();

                    state._fsp--;

                     result =c; 

                    }
                    break;
                case 3 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:60:4: p= preprocessor
                    {
                    pushFollow(FOLLOW_preprocessor_in_command135);
                    p=preprocessor();

                    state._fsp--;

                     result =p; 

                    }
                    break;
                case 4 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:61:4: o= output
                    {
                    pushFollow(FOLLOW_output_in_command144);
                    o=output();

                    state._fsp--;

                     result =o; 

                    }
                    break;
                case 5 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:62:4: i= include
                    {
                    pushFollow(FOLLOW_include_in_command153);
                    i=include();

                    state._fsp--;

                     result =i; 

                    }
                    break;
                case 6 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:63:4: v= var
                    {
                    pushFollow(FOLLOW_var_in_command162);
                    v=var();

                    state._fsp--;

                     result =v; 

                    }
                    break;
                case 7 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:64:4: iv= ipvar
                    {
                    pushFollow(FOLLOW_ipvar_in_command171);
                    iv=ipvar();

                    state._fsp--;

                     result =iv; 

                    }
                    break;
                case 8 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:65:4: pv= portvar
                    {
                    pushFollow(FOLLOW_portvar_in_command180);
                    pv=portvar();

                    state._fsp--;

                     result =pv; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "command"


    // $ANTLR start "var"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:67:1: var returns [Command result] : VAR na= VARNAME opts= untilnl ;
    public final Command var() throws RecognitionException {
        Command result = null;

        Token na=null;
        SnortFactoryParser.untilnl_return opts = null;


        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:68:2: ( VAR na= VARNAME opts= untilnl )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:68:4: VAR na= VARNAME opts= untilnl
            {
            match(input,VAR,FOLLOW_VAR_in_var196); 
            na=(Token)match(input,VARNAME,FOLLOW_VARNAME_in_var200); 
            pushFollow(FOLLOW_untilnl_in_var204);
            opts=untilnl();

            state._fsp--;

             result =new Var((na!=null?na.getText():null),(opts!=null?input.toString(opts.start,opts.stop):null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "var"


    // $ANTLR start "ipvar"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:70:1: ipvar returns [Command result] : IPVAR na= VARNAME a= address ;
    public final Command ipvar() throws RecognitionException {
        Command result = null;

        Token na=null;
        AddressList a = null;


        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:71:2: ( IPVAR na= VARNAME a= address )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:71:4: IPVAR na= VARNAME a= address
            {
            match(input,IPVAR,FOLLOW_IPVAR_in_ipvar220); 
            na=(Token)match(input,VARNAME,FOLLOW_VARNAME_in_ipvar224); 
            pushFollow(FOLLOW_address_in_ipvar228);
            a=address();

            state._fsp--;

             result =new AddressVar((na!=null?na.getText():null),a); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "ipvar"


    // $ANTLR start "portvar"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:73:1: portvar returns [Command result] : PORTVAR na= VARNAME p= port ;
    public final Command portvar() throws RecognitionException {
        Command result = null;

        Token na=null;
        PortList p = null;


        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:74:2: ( PORTVAR na= VARNAME p= port )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:74:4: PORTVAR na= VARNAME p= port
            {
            match(input,PORTVAR,FOLLOW_PORTVAR_in_portvar244); 
            na=(Token)match(input,VARNAME,FOLLOW_VARNAME_in_portvar248); 
            pushFollow(FOLLOW_port_in_portvar252);
            p=port();

            state._fsp--;

             result =new PortVar((na!=null?na.getText():null),p); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "portvar"


    // $ANTLR start "include"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:76:1: include returns [Command result] : INCLUDE file= untilnl ;
    public final Command include() throws RecognitionException {
        Command result = null;

        SnortFactoryParser.untilnl_return file = null;


        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:77:2: ( INCLUDE file= untilnl )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:77:4: INCLUDE file= untilnl
            {
            match(input,INCLUDE,FOLLOW_INCLUDE_in_include268); 
            pushFollow(FOLLOW_untilnl_in_include272);
            file=untilnl();

            state._fsp--;

             
            		result =new Include((file!=null?input.toString(file.start,file.stop):null)); 
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "include"


    // $ANTLR start "config"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:82:1: config returns [Command result] : ( CONFIG na= VARNAME COLON opts= untilnl | CONFIG na= VARNAME );
    public final Command config() throws RecognitionException {
        Command result = null;

        Token na=null;
        SnortFactoryParser.untilnl_return opts = null;


        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:83:2: ( CONFIG na= VARNAME COLON opts= untilnl | CONFIG na= VARNAME )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==CONFIG) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==VARNAME) ) {
                    int LA4_2 = input.LA(3);

                    if ( (LA4_2==COLON) ) {
                        alt4=1;
                    }
                    else if ( (LA4_2==EOF||(LA4_2>=COMMENT && LA4_2<=VAR)||(LA4_2>=IPVAR && LA4_2<=CONFIG)||(LA4_2>=PREPRO && LA4_2<=RULES)) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:83:4: CONFIG na= VARNAME COLON opts= untilnl
                    {
                    match(input,CONFIG,FOLLOW_CONFIG_in_config288); 
                    na=(Token)match(input,VARNAME,FOLLOW_VARNAME_in_config292); 
                    match(input,COLON,FOLLOW_COLON_in_config294); 
                    pushFollow(FOLLOW_untilnl_in_config298);
                    opts=untilnl();

                    state._fsp--;


                    		result =new Config((na!=null?na.getText():null),(opts!=null?input.toString(opts.start,opts.stop):null));
                    	

                    }
                    break;
                case 2 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:87:4: CONFIG na= VARNAME
                    {
                    match(input,CONFIG,FOLLOW_CONFIG_in_config306); 
                    na=(Token)match(input,VARNAME,FOLLOW_VARNAME_in_config310); 

                    		result =new Config((na!=null?na.getText():null));
                    	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "config"


    // $ANTLR start "preprocessor"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:92:1: preprocessor returns [Command result] : ( PREPRO na= VARNAME COLON opts= untilnl | PREPRO na= VARNAME );
    public final Command preprocessor() throws RecognitionException {
        Command result = null;

        Token na=null;
        SnortFactoryParser.untilnl_return opts = null;


        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:93:2: ( PREPRO na= VARNAME COLON opts= untilnl | PREPRO na= VARNAME )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PREPRO) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==VARNAME) ) {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2==COLON) ) {
                        alt5=1;
                    }
                    else if ( (LA5_2==EOF||(LA5_2>=COMMENT && LA5_2<=VAR)||(LA5_2>=IPVAR && LA5_2<=CONFIG)||(LA5_2>=PREPRO && LA5_2<=RULES)) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:93:4: PREPRO na= VARNAME COLON opts= untilnl
                    {
                    match(input,PREPRO,FOLLOW_PREPRO_in_preprocessor326); 
                    na=(Token)match(input,VARNAME,FOLLOW_VARNAME_in_preprocessor330); 
                    match(input,COLON,FOLLOW_COLON_in_preprocessor332); 
                    pushFollow(FOLLOW_untilnl_in_preprocessor336);
                    opts=untilnl();

                    state._fsp--;


                    		result =new Preprocessor((na!=null?na.getText():null),(opts!=null?input.toString(opts.start,opts.stop):null));
                    	

                    }
                    break;
                case 2 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:97:4: PREPRO na= VARNAME
                    {
                    match(input,PREPRO,FOLLOW_PREPRO_in_preprocessor344); 
                    na=(Token)match(input,VARNAME,FOLLOW_VARNAME_in_preprocessor348); 

                    		result =new Preprocessor((na!=null?na.getText():null));
                    	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "preprocessor"


    // $ANTLR start "output"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:102:1: output returns [Command result] : ( OUTPUT na= VARNAME COLON opts= untilnl | OUTPUT na= VARNAME );
    public final Command output() throws RecognitionException {
        Command result = null;

        Token na=null;
        SnortFactoryParser.untilnl_return opts = null;


        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:103:2: ( OUTPUT na= VARNAME COLON opts= untilnl | OUTPUT na= VARNAME )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==OUTPUT) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==VARNAME) ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2==COLON) ) {
                        alt6=1;
                    }
                    else if ( (LA6_2==EOF||(LA6_2>=COMMENT && LA6_2<=VAR)||(LA6_2>=IPVAR && LA6_2<=CONFIG)||(LA6_2>=PREPRO && LA6_2<=RULES)) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:103:4: OUTPUT na= VARNAME COLON opts= untilnl
                    {
                    match(input,OUTPUT,FOLLOW_OUTPUT_in_output365); 
                    na=(Token)match(input,VARNAME,FOLLOW_VARNAME_in_output369); 
                    match(input,COLON,FOLLOW_COLON_in_output371); 
                    pushFollow(FOLLOW_untilnl_in_output375);
                    opts=untilnl();

                    state._fsp--;


                    		result =new Output((na!=null?na.getText():null),(opts!=null?input.toString(opts.start,opts.stop):null));
                    	

                    }
                    break;
                case 2 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:107:4: OUTPUT na= VARNAME
                    {
                    match(input,OUTPUT,FOLLOW_OUTPUT_in_output383); 
                    na=(Token)match(input,VARNAME,FOLLOW_VARNAME_in_output387); 

                    		result =new Output((na!=null?na.getText():null));
                    	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "output"


    // $ANTLR start "rule"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:112:1: rule returns [Command result] : r= RULES adr1= vaddress port1= vport '->' adr2= vaddress port2= vport LB opts= untilrb RB ;
    public final Command rule() throws RecognitionException {
        Command result = null;

        Token r=null;
        AddressList adr1 = null;

        PortList port1 = null;

        AddressList adr2 = null;

        PortList port2 = null;

        SnortFactoryParser.untilrb_return opts = null;


        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:113:2: (r= RULES adr1= vaddress port1= vport '->' adr2= vaddress port2= vport LB opts= untilrb RB )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:113:4: r= RULES adr1= vaddress port1= vport '->' adr2= vaddress port2= vport LB opts= untilrb RB
            {
            r=(Token)match(input,RULES,FOLLOW_RULES_in_rule405); 
            pushFollow(FOLLOW_vaddress_in_rule409);
            adr1=vaddress();

            state._fsp--;

            pushFollow(FOLLOW_vport_in_rule413);
            port1=vport();

            state._fsp--;

            match(input,34,FOLLOW_34_in_rule415); 
            pushFollow(FOLLOW_vaddress_in_rule419);
            adr2=vaddress();

            state._fsp--;

            pushFollow(FOLLOW_vport_in_rule423);
            port2=vport();

            state._fsp--;

            match(input,LB,FOLLOW_LB_in_rule425); 
            pushFollow(FOLLOW_untilrb_in_rule429);
            opts=untilrb();

            state._fsp--;

            match(input,RB,FOLLOW_RB_in_rule431); 
             	
            		result =new Rule((r!=null?r.getText():null),adr1,port1,adr2,port2,(opts!=null?input.toString(opts.start,opts.stop):null));
            		//System.out.println("new Rule("+(r!=null?r.getText():null)+", "+adr1.toString()+","+port1.toString()+","+adr2.toString()+","+port2.toString()+","+(opts!=null?input.toString(opts.start,opts.stop):null)+");");
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "rule"


    // $ANTLR start "vaddress"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:119:1: vaddress returns [AddressList result] : (a= address | na= VARNAME );
    public final AddressList vaddress() throws RecognitionException {
        AddressList result = null;

        Token na=null;
        AddressList a = null;


        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:120:2: (a= address | na= VARNAME )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=NEG && LA7_0<=SLB)||LA7_0==ADDRESS) ) {
                alt7=1;
            }
            else if ( (LA7_0==VARNAME) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:120:4: a= address
                    {
                    pushFollow(FOLLOW_address_in_vaddress449);
                    a=address();

                    state._fsp--;

                     result =a; 

                    }
                    break;
                case 2 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:121:4: na= VARNAME
                    {
                    na=(Token)match(input,VARNAME,FOLLOW_VARNAME_in_vaddress458); 
                     result =((snort_scope)snort_stack.peek()).conf.getAddressVar((na!=null?na.getText():null)).getAddresses(); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "vaddress"


    // $ANTLR start "vport"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:123:1: vport returns [PortList result] : (p= port | na= VARNAME );
    public final PortList vport() throws RecognitionException {
        PortList result = null;

        Token na=null;
        PortList p = null;


        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:124:2: (p= port | na= VARNAME )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=NEG && LA8_0<=SLB)||LA8_0==NUMBER) ) {
                alt8=1;
            }
            else if ( (LA8_0==VARNAME) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:124:4: p= port
                    {
                    pushFollow(FOLLOW_port_in_vport476);
                    p=port();

                    state._fsp--;

                     result =p; 

                    }
                    break;
                case 2 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:125:4: na= VARNAME
                    {
                    na=(Token)match(input,VARNAME,FOLLOW_VARNAME_in_vport485); 
                     result =((snort_scope)snort_stack.peek()).conf.getPortVar((na!=null?na.getText():null)).getPorts(); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "vport"


    // $ANTLR start "address"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:127:1: address returns [AddressList result] : (a= adr | NEG SLB al= addressl SRB | SLB al= addressl SRB );
    public final AddressList address() throws RecognitionException {
        AddressList result = null;

        AddressList a = null;

        AddressList al = null;


        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:128:2: (a= adr | NEG SLB al= addressl SRB | SLB al= addressl SRB )
            int alt9=3;
            switch ( input.LA(1) ) {
            case ADDRESS:
                {
                alt9=1;
                }
                break;
            case NEG:
                {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==ADDRESS) ) {
                    alt9=1;
                }
                else if ( (LA9_2==SLB) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;
                }
                }
                break;
            case SLB:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:128:4: a= adr
                    {
                    pushFollow(FOLLOW_adr_in_address502);
                    a=adr();

                    state._fsp--;

                     result =a; 

                    }
                    break;
                case 2 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:129:4: NEG SLB al= addressl SRB
                    {
                    match(input,NEG,FOLLOW_NEG_in_address509); 
                    match(input,SLB,FOLLOW_SLB_in_address511); 
                    pushFollow(FOLLOW_addressl_in_address515);
                    al=addressl();

                    state._fsp--;

                    match(input,SRB,FOLLOW_SRB_in_address517); 

                    		result =al; 
                    		result.setNegator(true);
                    	

                    }
                    break;
                case 3 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:134:4: SLB al= addressl SRB
                    {
                    match(input,SLB,FOLLOW_SLB_in_address525); 
                    pushFollow(FOLLOW_addressl_in_address529);
                    al=addressl();

                    state._fsp--;

                    match(input,SRB,FOLLOW_SRB_in_address531); 

                    		result =al;
                    	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "address"


    // $ANTLR start "addressl"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:139:1: addressl returns [AddressList result] : (a= adr COMMA al= addressl | aa= adr );
    public final AddressList addressl() throws RecognitionException {
        AddressList result = null;

        AddressList a = null;

        AddressList al = null;

        AddressList aa = null;


        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:140:2: (a= adr COMMA al= addressl | aa= adr )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ADDRESS) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==SRB) ) {
                    alt10=2;
                }
                else if ( (LA10_1==COMMA) ) {
                    alt10=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA10_0==NEG) ) {
                int LA10_2 = input.LA(2);

                if ( (LA10_2==ADDRESS) ) {
                    int LA10_5 = input.LA(3);

                    if ( (LA10_5==SRB) ) {
                        alt10=2;
                    }
                    else if ( (LA10_5==COMMA) ) {
                        alt10=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 5, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:140:4: a= adr COMMA al= addressl
                    {
                    pushFollow(FOLLOW_adr_in_addressl550);
                    a=adr();

                    state._fsp--;

                    match(input,COMMA,FOLLOW_COMMA_in_addressl552); 
                    pushFollow(FOLLOW_addressl_in_addressl556);
                    al=addressl();

                    state._fsp--;


                    		a.add(al);
                    		result =a;
                    	

                    }
                    break;
                case 2 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:145:4: aa= adr
                    {
                    pushFollow(FOLLOW_adr_in_addressl566);
                    aa=adr();

                    state._fsp--;

                     result =aa; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "addressl"


    // $ANTLR start "adr"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:147:1: adr returns [AddressList result] : (a= ADDRESS | NEG a= ADDRESS );
    public final AddressList adr() throws RecognitionException {
        AddressList result = null;

        Token a=null;

        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:148:2: (a= ADDRESS | NEG a= ADDRESS )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ADDRESS) ) {
                alt11=1;
            }
            else if ( (LA11_0==NEG) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:148:4: a= ADDRESS
                    {
                    a=(Token)match(input,ADDRESS,FOLLOW_ADDRESS_in_adr584); 
                     result =new AddressList(new Address(false,(a!=null?a.getText():null))); 

                    }
                    break;
                case 2 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:150:4: NEG a= ADDRESS
                    {
                    match(input,NEG,FOLLOW_NEG_in_adr592); 
                    a=(Token)match(input,ADDRESS,FOLLOW_ADDRESS_in_adr596); 
                     result =new AddressList(new Address(true, (a!=null?a.getText():null))); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "adr"


    // $ANTLR start "port"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:157:1: port returns [PortList result] : (p= pt | (n= NEG )? SLB pl= portl SRB );
    public final PortList port() throws RecognitionException {
        PortList result = null;

        Token n=null;
        PortList p = null;

        PortList pl = null;


        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:158:2: (p= pt | (n= NEG )? SLB pl= portl SRB )
            int alt13=2;
            switch ( input.LA(1) ) {
            case NEG:
                {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==SLB) ) {
                    alt13=2;
                }
                else if ( (LA13_1==NUMBER) ) {
                    alt13=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
                }
                break;
            case NUMBER:
                {
                alt13=1;
                }
                break;
            case SLB:
                {
                alt13=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:158:4: p= pt
                    {
                    pushFollow(FOLLOW_pt_in_port649);
                    p=pt();

                    state._fsp--;

                     result =p; 

                    }
                    break;
                case 2 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:159:4: (n= NEG )? SLB pl= portl SRB
                    {
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:159:5: (n= NEG )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==NEG) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:159:5: n= NEG
                            {
                            n=(Token)match(input,NEG,FOLLOW_NEG_in_port658); 

                            }
                            break;

                    }

                    match(input,SLB,FOLLOW_SLB_in_port661); 
                    pushFollow(FOLLOW_portl_in_port665);
                    pl=portl();

                    state._fsp--;

                    match(input,SRB,FOLLOW_SRB_in_port667); 

                    		result =pl;
                    		if(n!=null) {
                    			result.setNegator(true);
                    		}
                    	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "port"


    // $ANTLR start "portl"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:167:1: portl returns [PortList result] : p= pt ( ',' pl= portl )? ;
    public final PortList portl() throws RecognitionException {
        PortList result = null;

        PortList p = null;

        PortList pl = null;


        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:168:2: (p= pt ( ',' pl= portl )? )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:168:4: p= pt ( ',' pl= portl )?
            {
            pushFollow(FOLLOW_pt_in_portl685);
            p=pt();

            state._fsp--;

            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:168:9: ( ',' pl= portl )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==COMMA) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:168:10: ',' pl= portl
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_portl688); 
                    pushFollow(FOLLOW_portl_in_portl692);
                    pl=portl();

                    state._fsp--;


                    }
                    break;

            }


            		result =p;
            		if(pl!=null) {
            			result.addAll(pl);
            		}
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "portl"


    // $ANTLR start "pt"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:176:1: pt returns [PortList result] : (n= NEG )? p= NUMBER ;
    public final PortList pt() throws RecognitionException {
        PortList result = null;

        Token n=null;
        Token p=null;

        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:177:2: ( (n= NEG )? p= NUMBER )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:177:4: (n= NEG )? p= NUMBER
            {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:177:5: (n= NEG )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==NEG) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:177:5: n= NEG
                    {
                    n=(Token)match(input,NEG,FOLLOW_NEG_in_pt713); 

                    }
                    break;

            }

            p=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_pt718); 

            		result =new PortList(new Port((n!=null?true:false),(p!=null?p.getText():null)));
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "pt"

    public static class untilnl_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "untilnl"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:182:1: untilnl : (~ ( '\\n' ) )+ ;
    public final SnortFactoryParser.untilnl_return untilnl() throws RecognitionException {
        SnortFactoryParser.untilnl_return retval = new SnortFactoryParser.untilnl_return();
        retval.start = input.LT(1);

        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:182:9: ( (~ ( '\\n' ) )+ )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:182:11: (~ ( '\\n' ) )+
            {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:182:11: (~ ( '\\n' ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                alt16 = dfa16.predict(input);
                switch (alt16) {
            	case 1 :
            	    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:182:11: ~ ( '\\n' )
            	    {
            	    if ( input.LA(1)==COMMENT||(input.LA(1)>=VAR && input.LA(1)<=34) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "untilnl"

    public static class untilrb_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "untilrb"
    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:184:1: untilrb : (~ ( ')' ) )+ ;
    public final SnortFactoryParser.untilrb_return untilrb() throws RecognitionException {
        SnortFactoryParser.untilrb_return retval = new SnortFactoryParser.untilrb_return();
        retval.start = input.LT(1);

        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:184:9: ( (~ ( ')' ) )+ )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:184:11: (~ ( ')' ) )+
            {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:184:11: (~ ( ')' ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=COMMENT && LA17_0<=LB)||(LA17_0>=NEG && LA17_0<=34)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:184:11: ~ ( ')' )
            	    {
            	    if ( (input.LA(1)>=COMMENT && input.LA(1)<=LB)||(input.LA(1)>=NEG && input.LA(1)<=34) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "untilrb"

    // Delegated rules


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\15\uffff";
    static final String DFA16_eofS =
        "\1\1\14\uffff";
    static final String DFA16_minS =
        "\1\4\14\uffff";
    static final String DFA16_maxS =
        "\1\42\14\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\2\11\1\2\uffff";
    static final String DFA16_specialS =
        "\15\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\2\1\1\1\10\1\7\1\11\1\12\1\7\1\4\1\7\1\5\1\6\1\3\23\7",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "()+ loopback of 182:11: (~ ( '\\n' ) )+";
        }
    }
 

    public static final BitSet FOLLOW_comment_in_snort51 = new BitSet(new long[]{0x000000000000EF72L});
    public static final BitSet FOLLOW_command_in_snort60 = new BitSet(new long[]{0x000000000000EF72L});
    public static final BitSet FOLLOW_empty_in_snort69 = new BitSet(new long[]{0x000000000000EF72L});
    public static final BitSet FOLLOW_COMMENT_in_comment82 = new BitSet(new long[]{0x00000007FFFFFFF0L});
    public static final BitSet FOLLOW_set_in_comment84 = new BitSet(new long[]{0x00000007FFFFFFF0L});
    public static final BitSet FOLLOW_set_in_comment90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_empty102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule_in_command117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_config_in_command126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_preprocessor_in_command135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_output_in_command144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_in_command153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_command162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ipvar_in_command171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_portvar_in_command180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_var196 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_VARNAME_in_var200 = new BitSet(new long[]{0x00000007FFFFFFD0L});
    public static final BitSet FOLLOW_untilnl_in_var204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IPVAR_in_ipvar220 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_VARNAME_in_ipvar224 = new BitSet(new long[]{0x00000000004C0000L});
    public static final BitSet FOLLOW_address_in_ipvar228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PORTVAR_in_portvar244 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_VARNAME_in_portvar248 = new BitSet(new long[]{0x00000000010C0000L});
    public static final BitSet FOLLOW_port_in_portvar252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_include268 = new BitSet(new long[]{0x00000007FFFFFFD0L});
    public static final BitSet FOLLOW_untilnl_in_include272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONFIG_in_config288 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_VARNAME_in_config292 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_config294 = new BitSet(new long[]{0x00000007FFFFFFD0L});
    public static final BitSet FOLLOW_untilnl_in_config298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONFIG_in_config306 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_VARNAME_in_config310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PREPRO_in_preprocessor326 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_VARNAME_in_preprocessor330 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_preprocessor332 = new BitSet(new long[]{0x00000007FFFFFFD0L});
    public static final BitSet FOLLOW_untilnl_in_preprocessor336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PREPRO_in_preprocessor344 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_VARNAME_in_preprocessor348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_output365 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_VARNAME_in_output369 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_output371 = new BitSet(new long[]{0x00000007FFFFFFD0L});
    public static final BitSet FOLLOW_untilnl_in_output375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_output383 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_VARNAME_in_output387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULES_in_rule405 = new BitSet(new long[]{0x00000000004C0080L});
    public static final BitSet FOLLOW_vaddress_in_rule409 = new BitSet(new long[]{0x00000000010C0080L});
    public static final BitSet FOLLOW_vport_in_rule413 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_rule415 = new BitSet(new long[]{0x00000000004C0080L});
    public static final BitSet FOLLOW_vaddress_in_rule419 = new BitSet(new long[]{0x00000000010C0080L});
    public static final BitSet FOLLOW_vport_in_rule423 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_LB_in_rule425 = new BitSet(new long[]{0x00000007FFFDFFF0L});
    public static final BitSet FOLLOW_untilrb_in_rule429 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RB_in_rule431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_address_in_vaddress449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARNAME_in_vaddress458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_port_in_vport476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARNAME_in_vport485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adr_in_address502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_address509 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_SLB_in_address511 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_addressl_in_address515 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SRB_in_address517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SLB_in_address525 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_addressl_in_address529 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SRB_in_address531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adr_in_addressl550 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_COMMA_in_addressl552 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_addressl_in_addressl556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adr_in_addressl566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADDRESS_in_adr584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_adr592 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ADDRESS_in_adr596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pt_in_port649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_port658 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_SLB_in_port661 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_portl_in_port665 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SRB_in_port667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pt_in_portl685 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_COMMA_in_portl688 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_portl_in_portl692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_pt713 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_NUMBER_in_pt718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_untilnl730 = new BitSet(new long[]{0x00000007FFFFFFD2L});
    public static final BitSet FOLLOW_set_in_untilrb742 = new BitSet(new long[]{0x00000007FFFDFFF2L});

}