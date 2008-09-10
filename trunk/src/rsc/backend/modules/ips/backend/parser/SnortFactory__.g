lexer grammar SnortFactory;

@header {
   package rsc.backend.modules.ips.backend.parser;
}

T__34 : '->' ;

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 153
SUB	:	SLASH NUMBER;

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 155
ADDRESS	:	NUMBER DOT NUMBER DOT NUMBER DOT NUMBER (SUB)?;

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 192
NEWLINE	:	'\n';
	
// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 194
VAR	:	'var';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 196
IPVAR	:	'ipvar';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 198
PORTVAR	:	'portvar';
	
// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 200
INCLUDE	:	'include';
	
// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 202
OUTPUT	:	'output';
	
// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 204
CONFIG	:	'config';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 206
PREPRO	:	'preprocessor';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 208
RULES	:	'alert' | 'log' | 'pass' | 'activate' | 'dynamic' | 'drop' | 'reject' | 'sdrop' /* | (a..z)+ */;

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 210
SYMBOL	:	'<' | '>' | '{' | '}' | '*' | '&' | '%' | '$' | '@' | '~' | '`' | '\'' | '\"' | '^' | '=' | '+' | '-' | ';' | '_';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 212
COMMENT :	'#';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 214
COLON	:	':';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 216
SLASH	:	'/';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 218
DIGIT	
	:	'0'..'9' ;

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 221
NEG	:	'!';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 223
SLB	:	'[';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 225
SRB	:	']';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 227
LB	:	'(';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 229
RB	:	')';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 231
DOT	:	'.';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 233
COMMA	:	',';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 235
LETTER
	:	LOWER | UPPER;

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 238
fragment LOWER
	:	'a'..'z';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 241
fragment UPPER
	:	'A'..'Z';
	
// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 244
WHITESPACE
	:	( '\t' | ' ' | '\r' | '\\\n'| '\u000C' )+ { $channel=HIDDEN; };
	
// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 247
VARNAME	:	LETTER (LETTER | DIGIT | '_')*;

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 249
VARREF	:	'$' LETTER (LETTER | DIGIT | '_')*;

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 251
NUMBER	:	DIGIT+;