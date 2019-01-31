// Generated from Header.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HeaderLexer extends Lexer {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
    T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, 
    T__16=17, T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, KEY_ACCIDENTAL=23, 
    MODE_MINOR=24, TITLE_TEXT=25, COMPOSER_TEXT=26, VOICE_TEXT=27, COMMENT_TEXT=28, 
    DIGITS=29, NEWLINE=30, WHITESPACE=31;
  public static String[] modeNames = {
    "DEFAULT_MODE"
  };

  public static final String[] ruleNames = {
    "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
    "T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
    "T__17", "T__18", "T__19", "T__20", "T__21", "KEY_ACCIDENTAL", "MODE_MINOR", 
    "TITLE_TEXT", "COMPOSER_TEXT", "VOICE_TEXT", "COMMENT_TEXT", "DIGITS", 
    "NEWLINE", "WHITESPACE"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'X:'", "'L:'", "'M:'", "'Q:'", "'K:'", "'/'", "'C'", "'C|'", 
    "'='", "'A'", "'B'", "'D'", "'E'", "'F'", "'G'", "'a'", "'b'", "'c'", 
    "'d'", "'e'", "'f'", "'g'", null, "'m'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, null, null, null, null, null, null, null, 
    null, null, null, null, null, null, null, null, null, null, null, "KEY_ACCIDENTAL", 
    "MODE_MINOR", "TITLE_TEXT", "COMPOSER_TEXT", "VOICE_TEXT", "COMMENT_TEXT", 
    "DIGITS", "NEWLINE", "WHITESPACE"
  };
  public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

  /**
   * @deprecated Use {@link #VOCABULARY} instead.
   */
  @Deprecated
  public static final String[] tokenNames;
  static {
    tokenNames = new String[_SYMBOLIC_NAMES.length];
    for (int i = 0; i < tokenNames.length; i++) {
      tokenNames[i] = VOCABULARY.getLiteralName(i);
      if (tokenNames[i] == null) {
        tokenNames[i] = VOCABULARY.getSymbolicName(i);
      }

      if (tokenNames[i] == null) {
        tokenNames[i] = "<INVALID>";
      }
    }
  }

  @Override
  @Deprecated
  public String[] getTokenNames() {
    return tokenNames;
  }

  @Override

  public Vocabulary getVocabulary() {
    return VOCABULARY;
  }


      // This method makes the parser stop running if it encounters
      // invalid input and throw a RuntimeException.
      public void reportErrorsAsExceptions() {
          // To prevent any reports to standard error, add this line:
          //removeErrorListeners();
          
          addErrorListener(new BaseErrorListener() {
              public void syntaxError(Recognizer<?, ?> recognizer,
                                      Object offendingSymbol, 
                                      int line, int charPositionInLine,
                                      String msg, RecognitionException e) {
                  throw new ParseCancellationException(msg, e);
              }
          });
      }


  public HeaderLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }

  @Override
  public String getGrammarFileName() { return "Header.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public String[] getModeNames() { return modeNames; }

  @Override
  public ATN getATN() { return _ATN; }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u00ac\b\1\4\2"+
      "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t"+
      "\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t"+
      "\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4"+
      "\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t"+
      "\36\4\37\t\37\4 \t \3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3"+
      "\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
      "\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
      "\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
      "\3\32\3\32\3\32\3\32\7\32|\n\32\f\32\16\32\177\13\32\3\33\3\33\3\33"+
      "\3\33\7\33\u0085\n\33\f\33\16\33\u0088\13\33\3\34\3\34\3\34\3\34\7"+
      "\34\u008e\n\34\f\34\16\34\u0091\13\34\3\35\3\35\7\35\u0095\n\35\f"+
      "\35\16\35\u0098\13\35\3\36\6\36\u009b\n\36\r\36\16\36\u009c\3\37\3"+
      "\37\3\37\5\37\u00a2\n\37\5\37\u00a4\n\37\3 \6 \u00a7\n \r \16 \u00a8"+
      "\3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
      "\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
      "\65\34\67\359\36;\37= ?!\3\2\7\4\2%%dd\5\2\f\f\17\17\'\'\4\2\f\f\17"+
      "\17\3\2\62;\4\2\13\13\"\"\u00b3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
      "\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
      "\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
      "\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
      "\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
      "\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
      "\2\2\2?\3\2\2\2\3A\3\2\2\2\5D\3\2\2\2\7G\3\2\2\2\tJ\3\2\2\2\13M\3"+
      "\2\2\2\rP\3\2\2\2\17R\3\2\2\2\21T\3\2\2\2\23W\3\2\2\2\25Y\3\2\2\2"+
      "\27[\3\2\2\2\31]\3\2\2\2\33_\3\2\2\2\35a\3\2\2\2\37c\3\2\2\2!e\3\2"+
      "\2\2#g\3\2\2\2%i\3\2\2\2\'k\3\2\2\2)m\3\2\2\2+o\3\2\2\2-q\3\2\2\2"+
      "/s\3\2\2\2\61u\3\2\2\2\63w\3\2\2\2\65\u0080\3\2\2\2\67\u0089\3\2\2"+
      "\29\u0092\3\2\2\2;\u009a\3\2\2\2=\u00a3\3\2\2\2?\u00a6\3\2\2\2AB\7"+
      "Z\2\2BC\7<\2\2C\4\3\2\2\2DE\7N\2\2EF\7<\2\2F\6\3\2\2\2GH\7O\2\2HI"+
      "\7<\2\2I\b\3\2\2\2JK\7S\2\2KL\7<\2\2L\n\3\2\2\2MN\7M\2\2NO\7<\2\2"+
      "O\f\3\2\2\2PQ\7\61\2\2Q\16\3\2\2\2RS\7E\2\2S\20\3\2\2\2TU\7E\2\2U"+
      "V\7~\2\2V\22\3\2\2\2WX\7?\2\2X\24\3\2\2\2YZ\7C\2\2Z\26\3\2\2\2[\\"+
      "\7D\2\2\\\30\3\2\2\2]^\7F\2\2^\32\3\2\2\2_`\7G\2\2`\34\3\2\2\2ab\7"+
      "H\2\2b\36\3\2\2\2cd\7I\2\2d \3\2\2\2ef\7c\2\2f\"\3\2\2\2gh\7d\2\2"+
      "h$\3\2\2\2ij\7e\2\2j&\3\2\2\2kl\7f\2\2l(\3\2\2\2mn\7g\2\2n*\3\2\2"+
      "\2op\7h\2\2p,\3\2\2\2qr\7i\2\2r.\3\2\2\2st\t\2\2\2t\60\3\2\2\2uv\7"+
      "o\2\2v\62\3\2\2\2wx\7V\2\2xy\7<\2\2y}\3\2\2\2z|\n\3\2\2{z\3\2\2\2"+
      "|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\64\3\2\2\2\177}\3\2\2\2\u0080\u0081"+
      "\7E\2\2\u0081\u0082\7<\2\2\u0082\u0086\3\2\2\2\u0083\u0085\n\3\2\2"+
      "\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086"+
      "\u0087\3\2\2\2\u0087\66\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7"+
      "X\2\2\u008a\u008b\7<\2\2\u008b\u008f\3\2\2\2\u008c\u008e\n\3\2\2\u008d"+
      "\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090"+
      "\3\2\2\2\u00908\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0096\7\'\2\2\u0093"+
      "\u0095\n\4\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094"+
      "\3\2\2\2\u0096\u0097\3\2\2\2\u0097:\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
      "\u009b\t\5\2\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a"+
      "\3\2\2\2\u009c\u009d\3\2\2\2\u009d<\3\2\2\2\u009e\u00a4\7\f\2\2\u009f"+
      "\u00a1\7\17\2\2\u00a0\u00a2\7\f\2\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2"+
      "\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u009e\3\2\2\2\u00a3\u009f\3\2\2"+
      "\2\u00a4>\3\2\2\2\u00a5\u00a7\t\6\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8"+
      "\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2"+
      "\2\u00aa\u00ab\b \2\2\u00ab@\3\2\2\2\13\2}\u0086\u008f\u0096\u009c"+
      "\u00a1\u00a3\u00a8\3\b\2\2";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}