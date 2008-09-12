lexer grammar SnortFactory;

@header {
/*
 * Copyright 2008 Marcel Richter
 * 
 * This file is part of RSC (Remote Service Configurator).
 *
 *  RSC is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  RSC is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

   package rsc.backend.modules.ips.backend.parser;
}

T__34 : '->' ;

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 210
SUB	:	SLASH NUMBER;

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 212
ADDRESS	:	NUMBER DOT NUMBER DOT NUMBER DOT NUMBER (SUB)?;

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 249
NEWLINE	:	'\n';
	
// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 251
VAR	:	'var';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 253
IPVAR	:	'ipvar';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 255
PORTVAR	:	'portvar';
	
// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 257
INCLUDE	:	'include';
	
// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 259
OUTPUT	:	'output';
	
// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 261
CONFIG	:	'config';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 263
PREPRO	:	'preprocessor';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 265
RULES	:	'alert' | 'log' | 'pass' | 'activate' | 'dynamic' | 'drop' | 'reject' | 'sdrop' /* | (a..z)+ */;

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 267
SYMBOL	:	'<' | '>' | '{' | '}' | '*' | '&' | '%' | '$' | '@' | '~' | '`' | '\'' | '\"' | '^' | '=' | '+' | '-' | ';' | '_';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 269
COMMENT :	'#';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 271
COLON	:	':';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 273
SLASH	:	'/';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 275
DIGIT	
	:	'0'..'9' ;

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 278
NEG	:	'!';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 280
SLB	:	'[';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 282
SRB	:	']';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 284
LB	:	'(';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 286
RB	:	')';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 288
DOT	:	'.';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 290
COMMA	:	',';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 292
LETTER
	:	LOWER | UPPER;

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 295
fragment LOWER
	:	'a'..'z';

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 298
fragment UPPER
	:	'A'..'Z';
	
// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 301
WHITESPACE
	:	( '\t' | ' ' | '\r' | '\\\n'| '\u000C' )+ { $channel=HIDDEN; };
	
// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 304
VARNAME	:	LETTER (LETTER | DIGIT | '_')*;

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 306
VARREF	:	'$' LETTER (LETTER | DIGIT | '_')*;

// $ANTLR src "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g" 308
NUMBER	:	DIGIT+;