// $ANTLR 3.1 src/rsc/backend/modules/ips/backend/parser/SnortFactory.g 2008-09-12 10:57:36

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SnortFactoryLexer extends Lexer {
    public static final int RB=17;
    public static final int SYMBOL=27;
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
    public static final int DIGIT=28;
    public static final int LOWER=29;
    public static final int COMMENT=4;
    public static final int DOT=26;
    public static final int OUTPUT=14;
    public static final int IPVAR=8;
    public static final int UPPER=30;
    public static final int RULES=15;

    // delegates
    // delegators

    public SnortFactoryLexer() {;} 
    public SnortFactoryLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SnortFactoryLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "src/rsc/backend/modules/ips/backend/parser/SnortFactory.g"; }

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:26:7: ( '->' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:26:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "SUB"
    public final void mSUB() throws RecognitionException {
        try {
            int _type = SUB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:210:5: ( SLASH NUMBER )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:210:7: SLASH NUMBER
            {
            mSLASH(); 
            mNUMBER(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUB"

    // $ANTLR start "ADDRESS"
    public final void mADDRESS() throws RecognitionException {
        try {
            int _type = ADDRESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:212:9: ( NUMBER DOT NUMBER DOT NUMBER DOT NUMBER ( SUB )? )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:212:11: NUMBER DOT NUMBER DOT NUMBER DOT NUMBER ( SUB )?
            {
            mNUMBER(); 
            mDOT(); 
            mNUMBER(); 
            mDOT(); 
            mNUMBER(); 
            mDOT(); 
            mNUMBER(); 
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:212:51: ( SUB )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='/') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:212:52: SUB
                    {
                    mSUB(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ADDRESS"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:249:9: ( '\\n' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:249:11: '\\n'
            {
            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "VAR"
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:251:5: ( 'var' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:251:7: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAR"

    // $ANTLR start "IPVAR"
    public final void mIPVAR() throws RecognitionException {
        try {
            int _type = IPVAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:253:7: ( 'ipvar' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:253:9: 'ipvar'
            {
            match("ipvar"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IPVAR"

    // $ANTLR start "PORTVAR"
    public final void mPORTVAR() throws RecognitionException {
        try {
            int _type = PORTVAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:255:9: ( 'portvar' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:255:11: 'portvar'
            {
            match("portvar"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PORTVAR"

    // $ANTLR start "INCLUDE"
    public final void mINCLUDE() throws RecognitionException {
        try {
            int _type = INCLUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:257:9: ( 'include' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:257:11: 'include'
            {
            match("include"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INCLUDE"

    // $ANTLR start "OUTPUT"
    public final void mOUTPUT() throws RecognitionException {
        try {
            int _type = OUTPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:259:8: ( 'output' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:259:10: 'output'
            {
            match("output"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OUTPUT"

    // $ANTLR start "CONFIG"
    public final void mCONFIG() throws RecognitionException {
        try {
            int _type = CONFIG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:261:8: ( 'config' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:261:10: 'config'
            {
            match("config"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONFIG"

    // $ANTLR start "PREPRO"
    public final void mPREPRO() throws RecognitionException {
        try {
            int _type = PREPRO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:263:8: ( 'preprocessor' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:263:10: 'preprocessor'
            {
            match("preprocessor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PREPRO"

    // $ANTLR start "RULES"
    public final void mRULES() throws RecognitionException {
        try {
            int _type = RULES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:265:7: ( 'alert' | 'log' | 'pass' | 'activate' | 'dynamic' | 'drop' | 'reject' | 'sdrop' )
            int alt2=8;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:265:9: 'alert'
                    {
                    match("alert"); 


                    }
                    break;
                case 2 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:265:19: 'log'
                    {
                    match("log"); 


                    }
                    break;
                case 3 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:265:27: 'pass'
                    {
                    match("pass"); 


                    }
                    break;
                case 4 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:265:36: 'activate'
                    {
                    match("activate"); 


                    }
                    break;
                case 5 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:265:49: 'dynamic'
                    {
                    match("dynamic"); 


                    }
                    break;
                case 6 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:265:61: 'drop'
                    {
                    match("drop"); 


                    }
                    break;
                case 7 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:265:70: 'reject'
                    {
                    match("reject"); 


                    }
                    break;
                case 8 :
                    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:265:81: 'sdrop'
                    {
                    match("sdrop"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULES"

    // $ANTLR start "SYMBOL"
    public final void mSYMBOL() throws RecognitionException {
        try {
            int _type = SYMBOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:267:8: ( '<' | '>' | '{' | '}' | '*' | '&' | '%' | '$' | '@' | '~' | '`' | '\\'' | '\\\"' | '^' | '=' | '+' | '-' | ';' | '_' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:
            {
            if ( input.LA(1)=='\"'||(input.LA(1)>='$' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='+')||input.LA(1)=='-'||(input.LA(1)>=';' && input.LA(1)<='>')||input.LA(1)=='@'||(input.LA(1)>='^' && input.LA(1)<='`')||input.LA(1)=='{'||(input.LA(1)>='}' && input.LA(1)<='~') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SYMBOL"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:269:9: ( '#' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:269:11: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:271:7: ( ':' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:271:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "SLASH"
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:273:7: ( '/' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:273:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SLASH"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            int _type = DIGIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:276:2: ( '0' .. '9' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:276:4: '0' .. '9'
            {
            matchRange('0','9'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "NEG"
    public final void mNEG() throws RecognitionException {
        try {
            int _type = NEG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:278:5: ( '!' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:278:7: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEG"

    // $ANTLR start "SLB"
    public final void mSLB() throws RecognitionException {
        try {
            int _type = SLB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:280:5: ( '[' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:280:7: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SLB"

    // $ANTLR start "SRB"
    public final void mSRB() throws RecognitionException {
        try {
            int _type = SRB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:282:5: ( ']' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:282:7: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SRB"

    // $ANTLR start "LB"
    public final void mLB() throws RecognitionException {
        try {
            int _type = LB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:284:4: ( '(' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:284:6: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LB"

    // $ANTLR start "RB"
    public final void mRB() throws RecognitionException {
        try {
            int _type = RB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:286:4: ( ')' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:286:6: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RB"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:288:5: ( '.' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:288:7: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:290:7: ( ',' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:290:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            int _type = LETTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:293:2: ( LOWER | UPPER )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "LOWER"
    public final void mLOWER() throws RecognitionException {
        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:296:2: ( 'a' .. 'z' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:296:4: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "LOWER"

    // $ANTLR start "UPPER"
    public final void mUPPER() throws RecognitionException {
        try {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:299:2: ( 'A' .. 'Z' )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:299:4: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UPPER"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:302:2: ( ( '\\t' | ' ' | '\\r' | '\\\\\\n' | '\\u000C' )+ )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:302:4: ( '\\t' | ' ' | '\\r' | '\\\\\\n' | '\\u000C' )+
            {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:302:4: ( '\\t' | ' ' | '\\r' | '\\\\\\n' | '\\u000C' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=6;
                switch ( input.LA(1) ) {
                case '\t':
                    {
                    alt3=1;
                    }
                    break;
                case ' ':
                    {
                    alt3=2;
                    }
                    break;
                case '\r':
                    {
                    alt3=3;
                    }
                    break;
                case '\\':
                    {
                    alt3=4;
                    }
                    break;
                case '\f':
                    {
                    alt3=5;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:302:6: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;
            	case 2 :
            	    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:302:13: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 3 :
            	    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:302:19: '\\r'
            	    {
            	    match('\r'); 

            	    }
            	    break;
            	case 4 :
            	    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:302:26: '\\\\\\n'
            	    {
            	    match("\\\n"); 


            	    }
            	    break;
            	case 5 :
            	    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:302:34: '\\u000C'
            	    {
            	    match('\f'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "VARNAME"
    public final void mVARNAME() throws RecognitionException {
        try {
            int _type = VARNAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:304:9: ( LETTER ( LETTER | DIGIT | '_' )* )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:304:11: LETTER ( LETTER | DIGIT | '_' )*
            {
            mLETTER(); 
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:304:18: ( LETTER | DIGIT | '_' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VARNAME"

    // $ANTLR start "VARREF"
    public final void mVARREF() throws RecognitionException {
        try {
            int _type = VARREF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:306:8: ( '$' LETTER ( LETTER | DIGIT | '_' )* )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:306:10: '$' LETTER ( LETTER | DIGIT | '_' )*
            {
            match('$'); 
            mLETTER(); 
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:306:21: ( LETTER | DIGIT | '_' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VARREF"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:308:8: ( ( DIGIT )+ )
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:308:10: ( DIGIT )+
            {
            // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:308:10: ( DIGIT )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:308:10: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    public void mTokens() throws RecognitionException {
        // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:8: ( T__34 | SUB | ADDRESS | NEWLINE | VAR | IPVAR | PORTVAR | INCLUDE | OUTPUT | CONFIG | PREPRO | RULES | SYMBOL | COMMENT | COLON | SLASH | DIGIT | NEG | SLB | SRB | LB | RB | DOT | COMMA | LETTER | WHITESPACE | VARNAME | VARREF | NUMBER )
        int alt7=29;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:10: T__34
                {
                mT__34(); 

                }
                break;
            case 2 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:16: SUB
                {
                mSUB(); 

                }
                break;
            case 3 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:20: ADDRESS
                {
                mADDRESS(); 

                }
                break;
            case 4 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:28: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 5 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:36: VAR
                {
                mVAR(); 

                }
                break;
            case 6 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:40: IPVAR
                {
                mIPVAR(); 

                }
                break;
            case 7 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:46: PORTVAR
                {
                mPORTVAR(); 

                }
                break;
            case 8 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:54: INCLUDE
                {
                mINCLUDE(); 

                }
                break;
            case 9 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:62: OUTPUT
                {
                mOUTPUT(); 

                }
                break;
            case 10 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:69: CONFIG
                {
                mCONFIG(); 

                }
                break;
            case 11 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:76: PREPRO
                {
                mPREPRO(); 

                }
                break;
            case 12 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:83: RULES
                {
                mRULES(); 

                }
                break;
            case 13 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:89: SYMBOL
                {
                mSYMBOL(); 

                }
                break;
            case 14 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:96: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 15 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:104: COLON
                {
                mCOLON(); 

                }
                break;
            case 16 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:110: SLASH
                {
                mSLASH(); 

                }
                break;
            case 17 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:116: DIGIT
                {
                mDIGIT(); 

                }
                break;
            case 18 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:122: NEG
                {
                mNEG(); 

                }
                break;
            case 19 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:126: SLB
                {
                mSLB(); 

                }
                break;
            case 20 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:130: SRB
                {
                mSRB(); 

                }
                break;
            case 21 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:134: LB
                {
                mLB(); 

                }
                break;
            case 22 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:137: RB
                {
                mRB(); 

                }
                break;
            case 23 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:140: DOT
                {
                mDOT(); 

                }
                break;
            case 24 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:144: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 25 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:150: LETTER
                {
                mLETTER(); 

                }
                break;
            case 26 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:157: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 27 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:168: VARNAME
                {
                mVARNAME(); 

                }
                break;
            case 28 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:176: VARREF
                {
                mVARREF(); 

                }
                break;
            case 29 :
                // src/rsc/backend/modules/ips/backend/parser/SnortFactory.g:1:183: NUMBER
                {
                mNUMBER(); 

                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA2_eotS =
        "\13\uffff";
    static final String DFA2_eofS =
        "\13\uffff";
    static final String DFA2_minS =
        "\1\141\1\143\2\uffff\1\162\6\uffff";
    static final String DFA2_maxS =
        "\1\163\1\154\2\uffff\1\171\6\uffff";
    static final String DFA2_acceptS =
        "\2\uffff\1\2\1\3\1\uffff\1\7\1\10\1\1\1\4\1\5\1\6";
    static final String DFA2_specialS =
        "\13\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1\2\uffff\1\4\7\uffff\1\2\3\uffff\1\3\1\uffff\1\5\1\6",
            "\1\10\10\uffff\1\7",
            "",
            "",
            "\1\12\6\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "265:1: RULES : ( 'alert' | 'log' | 'pass' | 'activate' | 'dynamic' | 'drop' | 'reject' | 'sdrop' );";
        }
    }
    static final String DFA7_eotS =
        "\1\uffff\1\33\1\35\1\37\1\uffff\12\43\1\33\11\uffff\1\43\6\uffff"+
        "\1\64\1\uffff\1\44\2\uffff\16\44\2\uffff\1\104\11\44\1\116\4\44"+
        "\1\uffff\4\44\1\116\4\44\1\uffff\1\44\1\116\2\44\1\136\5\44\1\116"+
        "\3\44\1\116\1\uffff\3\44\1\152\1\153\2\44\1\116\1\156\1\157\1\44"+
        "\2\uffff\1\44\1\116\2\uffff\1\44\1\116\3\44\1\166\1\uffff";
    static final String DFA7_eofS =
        "\167\uffff";
    static final String DFA7_minS =
        "\1\11\1\76\1\60\1\56\1\uffff\12\60\1\101\11\uffff\1\60\6\uffff\1"+
        "\56\1\uffff\1\162\2\uffff\1\166\1\143\1\162\1\145\1\163\1\164\1"+
        "\156\1\145\1\164\1\147\1\156\1\157\1\152\1\162\2\uffff\1\60\1\141"+
        "\1\154\1\164\1\160\1\163\1\160\1\146\1\162\1\151\1\60\1\141\1\160"+
        "\1\145\1\157\1\uffff\1\162\1\165\1\166\1\162\1\60\1\165\1\151\1"+
        "\164\1\166\1\uffff\1\155\1\60\1\143\1\160\1\60\1\144\1\141\1\157"+
        "\1\164\1\147\1\60\1\141\1\151\1\164\1\60\1\uffff\1\145\1\162\1\143"+
        "\2\60\1\164\1\143\3\60\1\145\2\uffff\1\145\1\60\2\uffff\1\163\1"+
        "\60\1\163\1\157\1\162\1\60\1\uffff";
    static final String DFA7_maxS =
        "\1\176\1\76\2\71\1\uffff\13\172\11\uffff\1\172\6\uffff\1\71\1\uffff"+
        "\1\162\2\uffff\1\166\1\143\1\162\1\145\1\163\1\164\1\156\1\145\1"+
        "\164\1\147\1\156\1\157\1\152\1\162\2\uffff\1\172\1\141\1\154\1\164"+
        "\1\160\1\163\1\160\1\146\1\162\1\151\1\172\1\141\1\160\1\145\1\157"+
        "\1\uffff\1\162\1\165\1\166\1\162\1\172\1\165\1\151\1\164\1\166\1"+
        "\uffff\1\155\1\172\1\143\1\160\1\172\1\144\1\141\1\157\1\164\1\147"+
        "\1\172\1\141\1\151\1\164\1\172\1\uffff\1\145\1\162\1\143\2\172\1"+
        "\164\1\143\3\172\1\145\2\uffff\1\145\1\172\2\uffff\1\163\1\172\1"+
        "\163\1\157\1\162\1\172\1\uffff";
    static final String DFA7_acceptS =
        "\4\uffff\1\4\13\uffff\1\16\1\17\1\22\1\23\1\24\1\25\1\26\1\27\1"+
        "\30\1\uffff\1\32\1\15\1\1\1\20\1\2\1\21\1\uffff\1\3\1\uffff\1\31"+
        "\1\33\16\uffff\1\34\1\35\17\uffff\1\5\11\uffff\1\14\17\uffff\1\6"+
        "\13\uffff\1\11\1\12\2\uffff\1\10\1\7\6\uffff\1\13";
    static final String DFA7_specialS =
        "\167\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\32\1\4\1\uffff\2\32\22\uffff\1\32\1\22\1\33\1\20\1\17\3\33"+
            "\1\25\1\26\2\33\1\30\1\1\1\27\1\2\12\3\1\21\4\33\1\uffff\1\33"+
            "\32\31\1\23\1\32\1\24\3\33\1\12\1\31\1\11\1\14\4\31\1\6\2\31"+
            "\1\13\2\31\1\10\1\7\1\31\1\15\1\16\2\31\1\5\4\31\1\33\1\uffff"+
            "\2\33",
            "\1\34",
            "\12\36",
            "\1\41\1\uffff\12\40",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\1\42\31\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\15\44\1\46\1\44\1"+
            "\45\12\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\1\51\15\44\1\47\2"+
            "\44\1\50\10\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\24\44\1\52\5\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\16\44\1\53\13\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\2\44\1\55\10\44\1"+
            "\54\16\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\16\44\1\56\13\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\21\44\1\60\6\44\1"+
            "\57\1\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\61\25\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\3\44\1\62\26\44",
            "\32\63\6\uffff\32\63",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\41\1\uffff\12\40",
            "",
            "\1\65",
            "",
            "",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "",
            "\1\133",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\134",
            "\1\135",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\144",
            "\1\145",
            "\1\146",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\147",
            "\1\150",
            "\1\151",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\154",
            "\1\155",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\160",
            "",
            "",
            "\1\161",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "\1\162",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\163",
            "\1\164",
            "\1\165",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__34 | SUB | ADDRESS | NEWLINE | VAR | IPVAR | PORTVAR | INCLUDE | OUTPUT | CONFIG | PREPRO | RULES | SYMBOL | COMMENT | COLON | SLASH | DIGIT | NEG | SLB | SRB | LB | RB | DOT | COMMA | LETTER | WHITESPACE | VARNAME | VARREF | NUMBER );";
        }
    }
 

}