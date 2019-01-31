// Generated from Music.g4 by ANTLR 4.5.1

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
public class MusicLexer extends Lexer {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, OCTAVE=5, BASENOTE=6, ACCIDENTAL=7, 
    REST=8, BARLINE=9, NTH_REPEAT=10, VOICE_TEXT=11, COMMENT_TEXT=12, DIGIT=13, 
    NEWLINE=14, WHITESPACE=15;
  public static String[] modeNames = {
    "DEFAULT_MODE"
  };

  public static final String[] ruleNames = {
    "T__0", "T__1", "T__2", "T__3", "OCTAVE", "BASENOTE", "ACCIDENTAL", 
    "REST", "BARLINE", "NTH_REPEAT", "VOICE_TEXT", "COMMENT_TEXT", "DIGIT", 
    "NEWLINE", "WHITESPACE"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'/'", "'('", "'['", "']'", null, null, null, "'z'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, "OCTAVE", "BASENOTE", "ACCIDENTAL", "REST", 
    "BARLINE", "NTH_REPEAT", "VOICE_TEXT", "COMMENT_TEXT", "DIGIT", "NEWLINE", 
    "WHITESPACE"
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


  public MusicLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }

  @Override
  public String getGrammarFileName() { return "Music.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public String[] getModeNames() { return modeNames; }

  @Override
  public ATN getATN() { return _ATN; }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21p\b\1\4\2\t\2"+
      "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
      "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3"+
      "\3\3\3\4\3\4\3\5\3\5\3\6\6\6+\n\6\r\6\16\6,\3\6\6\6\60\n\6\r\6\16"+
      "\6\61\5\6\64\n\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b?\n\b\3\t"+
      "\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nN\n\n\3\13\3\13"+
      "\3\13\3\13\5\13T\n\13\3\f\3\f\3\f\3\f\7\fZ\n\f\f\f\16\f]\13\f\3\r"+
      "\3\r\7\ra\n\r\f\r\16\rd\13\r\3\16\3\16\3\17\3\17\3\17\5\17k\n\17\5"+
      "\17m\n\17\3\20\3\20\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
      "\25\f\27\r\31\16\33\17\35\20\37\21\3\2\7\4\2CIci\5\2\f\f\17\17\'\'"+
      "\4\2\f\f\17\17\3\2\62;\4\2\13\13\"\"\u0080\2\3\3\2\2\2\2\5\3\2\2\2"+
      "\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
      "\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
      "\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2\2\2\5#\3\2\2\2\7%\3\2\2"+
      "\2\t\'\3\2\2\2\13\63\3\2\2\2\r\65\3\2\2\2\17>\3\2\2\2\21@\3\2\2\2"+
      "\23M\3\2\2\2\25S\3\2\2\2\27U\3\2\2\2\31^\3\2\2\2\33e\3\2\2\2\35l\3"+
      "\2\2\2\37n\3\2\2\2!\"\7\61\2\2\"\4\3\2\2\2#$\7*\2\2$\6\3\2\2\2%&\7"+
      "]\2\2&\b\3\2\2\2\'(\7_\2\2(\n\3\2\2\2)+\7)\2\2*)\3\2\2\2+,\3\2\2\2"+
      ",*\3\2\2\2,-\3\2\2\2-\64\3\2\2\2.\60\7.\2\2/.\3\2\2\2\60\61\3\2\2"+
      "\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63*\3\2\2\2\63/\3\2\2\2"+
      "\64\f\3\2\2\2\65\66\t\2\2\2\66\16\3\2\2\2\67?\7`\2\289\7`\2\29?\7"+
      "`\2\2:?\7a\2\2;<\7a\2\2<?\7a\2\2=?\7?\2\2>\67\3\2\2\2>8\3\2\2\2>:"+
      "\3\2\2\2>;\3\2\2\2>=\3\2\2\2?\20\3\2\2\2@A\7|\2\2A\22\3\2\2\2BN\7"+
      "~\2\2CD\7~\2\2DN\7~\2\2EF\7]\2\2FN\7~\2\2GH\7~\2\2HN\7_\2\2IJ\7<\2"+
      "\2JN\7~\2\2KL\7~\2\2LN\7<\2\2MB\3\2\2\2MC\3\2\2\2ME\3\2\2\2MG\3\2"+
      "\2\2MI\3\2\2\2MK\3\2\2\2N\24\3\2\2\2OP\7]\2\2PT\7\63\2\2QR\7]\2\2"+
      "RT\7\64\2\2SO\3\2\2\2SQ\3\2\2\2T\26\3\2\2\2UV\7X\2\2VW\7<\2\2W[\3"+
      "\2\2\2XZ\n\3\2\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\30\3\2"+
      "\2\2][\3\2\2\2^b\7\'\2\2_a\n\4\2\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2b"+
      "c\3\2\2\2c\32\3\2\2\2db\3\2\2\2ef\t\5\2\2f\34\3\2\2\2gm\7\f\2\2hj"+
      "\7\17\2\2ik\7\f\2\2ji\3\2\2\2jk\3\2\2\2km\3\2\2\2lg\3\2\2\2lh\3\2"+
      "\2\2m\36\3\2\2\2no\t\6\2\2o \3\2\2\2\r\2,\61\63>MS[bjl\2";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}