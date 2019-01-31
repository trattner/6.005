// Generated from Header.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HeaderParser extends Parser {
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
  public static final int
    RULE_root = 0, RULE_header = 1, RULE_field_number = 2, RULE_field_title = 3, 
    RULE_other_fields = 4, RULE_field_composer = 5, RULE_field_default_length = 6, 
    RULE_field_meter = 7, RULE_field_tempo = 8, RULE_field_voice = 9, RULE_field_key = 10, 
    RULE_fraction = 11, RULE_meter = 12, RULE_tempo = 13, RULE_key = 14, 
    RULE_keynote = 15, RULE_basenote = 16, RULE_comment = 17, RULE_end_of_line = 18;
  public static final String[] ruleNames = {
    "root", "header", "field_number", "field_title", "other_fields", "field_composer", 
    "field_default_length", "field_meter", "field_tempo", "field_voice", 
    "field_key", "fraction", "meter", "tempo", "key", "keynote", "basenote", 
    "comment", "end_of_line"
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

  @Override
  public String getGrammarFileName() { return "Header.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public ATN getATN() { return _ATN; }


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

  public HeaderParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class RootContext extends ParserRuleContext {
    public HeaderContext header() {
      return getRuleContext(HeaderContext.class,0);
    }
    public TerminalNode EOF() { return getToken(HeaderParser.EOF, 0); }
    public RootContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_root; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterRoot(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitRoot(this);
    }
  }

  public final RootContext root() throws RecognitionException {
    RootContext _localctx = new RootContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_root);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(38);
      header();
      setState(39);
      match(EOF);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class HeaderContext extends ParserRuleContext {
    public Field_numberContext field_number() {
      return getRuleContext(Field_numberContext.class,0);
    }
    public Field_titleContext field_title() {
      return getRuleContext(Field_titleContext.class,0);
    }
    public Field_keyContext field_key() {
      return getRuleContext(Field_keyContext.class,0);
    }
    public List<CommentContext> comment() {
      return getRuleContexts(CommentContext.class);
    }
    public CommentContext comment(int i) {
      return getRuleContext(CommentContext.class,i);
    }
    public List<Other_fieldsContext> other_fields() {
      return getRuleContexts(Other_fieldsContext.class);
    }
    public Other_fieldsContext other_fields(int i) {
      return getRuleContext(Other_fieldsContext.class,i);
    }
    public HeaderContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_header; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterHeader(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitHeader(this);
    }
  }

  public final HeaderContext header() throws RecognitionException {
    HeaderContext _localctx = new HeaderContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_header);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(41);
      field_number();
      setState(45);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==COMMENT_TEXT) {
        {
        {
        setState(42);
        comment();
        }
        }
        setState(47);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(48);
      field_title();
      setState(52);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << COMPOSER_TEXT) | (1L << VOICE_TEXT) | (1L << COMMENT_TEXT))) != 0)) {
        {
        {
        setState(49);
        other_fields();
        }
        }
        setState(54);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(55);
      field_key();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class Field_numberContext extends ParserRuleContext {
    public TerminalNode DIGITS() { return getToken(HeaderParser.DIGITS, 0); }
    public End_of_lineContext end_of_line() {
      return getRuleContext(End_of_lineContext.class,0);
    }
    public Field_numberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_number; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterField_number(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitField_number(this);
    }
  }

  public final Field_numberContext field_number() throws RecognitionException {
    Field_numberContext _localctx = new Field_numberContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_field_number);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(57);
      match(T__0);
      setState(58);
      match(DIGITS);
      setState(59);
      end_of_line();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class Field_titleContext extends ParserRuleContext {
    public TerminalNode TITLE_TEXT() { return getToken(HeaderParser.TITLE_TEXT, 0); }
    public End_of_lineContext end_of_line() {
      return getRuleContext(End_of_lineContext.class,0);
    }
    public Field_titleContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_title; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterField_title(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitField_title(this);
    }
  }

  public final Field_titleContext field_title() throws RecognitionException {
    Field_titleContext _localctx = new Field_titleContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_field_title);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(61);
      match(TITLE_TEXT);
      setState(62);
      end_of_line();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class Other_fieldsContext extends ParserRuleContext {
    public Field_composerContext field_composer() {
      return getRuleContext(Field_composerContext.class,0);
    }
    public Field_default_lengthContext field_default_length() {
      return getRuleContext(Field_default_lengthContext.class,0);
    }
    public Field_meterContext field_meter() {
      return getRuleContext(Field_meterContext.class,0);
    }
    public Field_tempoContext field_tempo() {
      return getRuleContext(Field_tempoContext.class,0);
    }
    public Field_voiceContext field_voice() {
      return getRuleContext(Field_voiceContext.class,0);
    }
    public CommentContext comment() {
      return getRuleContext(CommentContext.class,0);
    }
    public Other_fieldsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_other_fields; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterOther_fields(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitOther_fields(this);
    }
  }

  public final Other_fieldsContext other_fields() throws RecognitionException {
    Other_fieldsContext _localctx = new Other_fieldsContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_other_fields);
    try {
      setState(70);
      switch (_input.LA(1)) {
      case COMPOSER_TEXT:
        enterOuterAlt(_localctx, 1);
        {
        setState(64);
        field_composer();
        }
        break;
      case T__1:
        enterOuterAlt(_localctx, 2);
        {
        setState(65);
        field_default_length();
        }
        break;
      case T__2:
        enterOuterAlt(_localctx, 3);
        {
        setState(66);
        field_meter();
        }
        break;
      case T__3:
        enterOuterAlt(_localctx, 4);
        {
        setState(67);
        field_tempo();
        }
        break;
      case VOICE_TEXT:
        enterOuterAlt(_localctx, 5);
        {
        setState(68);
        field_voice();
        }
        break;
      case COMMENT_TEXT:
        enterOuterAlt(_localctx, 6);
        {
        setState(69);
        comment();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class Field_composerContext extends ParserRuleContext {
    public TerminalNode COMPOSER_TEXT() { return getToken(HeaderParser.COMPOSER_TEXT, 0); }
    public End_of_lineContext end_of_line() {
      return getRuleContext(End_of_lineContext.class,0);
    }
    public Field_composerContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_composer; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterField_composer(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitField_composer(this);
    }
  }

  public final Field_composerContext field_composer() throws RecognitionException {
    Field_composerContext _localctx = new Field_composerContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_field_composer);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(72);
      match(COMPOSER_TEXT);
      setState(73);
      end_of_line();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class Field_default_lengthContext extends ParserRuleContext {
    public FractionContext fraction() {
      return getRuleContext(FractionContext.class,0);
    }
    public End_of_lineContext end_of_line() {
      return getRuleContext(End_of_lineContext.class,0);
    }
    public Field_default_lengthContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_default_length; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterField_default_length(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitField_default_length(this);
    }
  }

  public final Field_default_lengthContext field_default_length() throws RecognitionException {
    Field_default_lengthContext _localctx = new Field_default_lengthContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_field_default_length);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(75);
      match(T__1);
      setState(76);
      fraction();
      setState(77);
      end_of_line();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class Field_meterContext extends ParserRuleContext {
    public MeterContext meter() {
      return getRuleContext(MeterContext.class,0);
    }
    public End_of_lineContext end_of_line() {
      return getRuleContext(End_of_lineContext.class,0);
    }
    public Field_meterContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_meter; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterField_meter(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitField_meter(this);
    }
  }

  public final Field_meterContext field_meter() throws RecognitionException {
    Field_meterContext _localctx = new Field_meterContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_field_meter);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(79);
      match(T__2);
      setState(80);
      meter();
      setState(81);
      end_of_line();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class Field_tempoContext extends ParserRuleContext {
    public TempoContext tempo() {
      return getRuleContext(TempoContext.class,0);
    }
    public End_of_lineContext end_of_line() {
      return getRuleContext(End_of_lineContext.class,0);
    }
    public Field_tempoContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_tempo; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterField_tempo(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitField_tempo(this);
    }
  }

  public final Field_tempoContext field_tempo() throws RecognitionException {
    Field_tempoContext _localctx = new Field_tempoContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_field_tempo);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(83);
      match(T__3);
      setState(84);
      tempo();
      setState(85);
      end_of_line();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class Field_voiceContext extends ParserRuleContext {
    public TerminalNode VOICE_TEXT() { return getToken(HeaderParser.VOICE_TEXT, 0); }
    public End_of_lineContext end_of_line() {
      return getRuleContext(End_of_lineContext.class,0);
    }
    public Field_voiceContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_voice; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterField_voice(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitField_voice(this);
    }
  }

  public final Field_voiceContext field_voice() throws RecognitionException {
    Field_voiceContext _localctx = new Field_voiceContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_field_voice);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(87);
      match(VOICE_TEXT);
      setState(88);
      end_of_line();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class Field_keyContext extends ParserRuleContext {
    public KeyContext key() {
      return getRuleContext(KeyContext.class,0);
    }
    public End_of_lineContext end_of_line() {
      return getRuleContext(End_of_lineContext.class,0);
    }
    public Field_keyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_key; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterField_key(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitField_key(this);
    }
  }

  public final Field_keyContext field_key() throws RecognitionException {
    Field_keyContext _localctx = new Field_keyContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_field_key);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(90);
      match(T__4);
      setState(91);
      key();
      setState(92);
      end_of_line();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class FractionContext extends ParserRuleContext {
    public List<TerminalNode> DIGITS() { return getTokens(HeaderParser.DIGITS); }
    public TerminalNode DIGITS(int i) {
      return getToken(HeaderParser.DIGITS, i);
    }
    public FractionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_fraction; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterFraction(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitFraction(this);
    }
  }

  public final FractionContext fraction() throws RecognitionException {
    FractionContext _localctx = new FractionContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_fraction);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(94);
      match(DIGITS);
      setState(95);
      match(T__5);
      setState(96);
      match(DIGITS);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class MeterContext extends ParserRuleContext {
    public FractionContext fraction() {
      return getRuleContext(FractionContext.class,0);
    }
    public MeterContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_meter; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterMeter(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitMeter(this);
    }
  }

  public final MeterContext meter() throws RecognitionException {
    MeterContext _localctx = new MeterContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_meter);
    try {
      setState(101);
      switch (_input.LA(1)) {
      case T__6:
        enterOuterAlt(_localctx, 1);
        {
        setState(98);
        match(T__6);
        }
        break;
      case T__7:
        enterOuterAlt(_localctx, 2);
        {
        setState(99);
        match(T__7);
        }
        break;
      case DIGITS:
        enterOuterAlt(_localctx, 3);
        {
        setState(100);
        fraction();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class TempoContext extends ParserRuleContext {
    public FractionContext fraction() {
      return getRuleContext(FractionContext.class,0);
    }
    public TerminalNode DIGITS() { return getToken(HeaderParser.DIGITS, 0); }
    public TempoContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_tempo; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterTempo(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitTempo(this);
    }
  }

  public final TempoContext tempo() throws RecognitionException {
    TempoContext _localctx = new TempoContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_tempo);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(103);
      fraction();
      setState(104);
      match(T__8);
      setState(105);
      match(DIGITS);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class KeyContext extends ParserRuleContext {
    public KeynoteContext keynote() {
      return getRuleContext(KeynoteContext.class,0);
    }
    public TerminalNode MODE_MINOR() { return getToken(HeaderParser.MODE_MINOR, 0); }
    public KeyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_key; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterKey(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitKey(this);
    }
  }

  public final KeyContext key() throws RecognitionException {
    KeyContext _localctx = new KeyContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_key);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(107);
      keynote();
      setState(109);
      _la = _input.LA(1);
      if (_la==MODE_MINOR) {
        {
        setState(108);
        match(MODE_MINOR);
        }
      }

      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class KeynoteContext extends ParserRuleContext {
    public BasenoteContext basenote() {
      return getRuleContext(BasenoteContext.class,0);
    }
    public TerminalNode KEY_ACCIDENTAL() { return getToken(HeaderParser.KEY_ACCIDENTAL, 0); }
    public KeynoteContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_keynote; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterKeynote(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitKeynote(this);
    }
  }

  public final KeynoteContext keynote() throws RecognitionException {
    KeynoteContext _localctx = new KeynoteContext(_ctx, getState());
    enterRule(_localctx, 30, RULE_keynote);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(111);
      basenote();
      setState(113);
      _la = _input.LA(1);
      if (_la==KEY_ACCIDENTAL) {
        {
        setState(112);
        match(KEY_ACCIDENTAL);
        }
      }

      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class BasenoteContext extends ParserRuleContext {
    public BasenoteContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_basenote; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterBasenote(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitBasenote(this);
    }
  }

  public final BasenoteContext basenote() throws RecognitionException {
    BasenoteContext _localctx = new BasenoteContext(_ctx, getState());
    enterRule(_localctx, 32, RULE_basenote);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(115);
      _la = _input.LA(1);
      if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
      _errHandler.recoverInline(this);
      } else {
        consume();
      }
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class CommentContext extends ParserRuleContext {
    public TerminalNode COMMENT_TEXT() { return getToken(HeaderParser.COMMENT_TEXT, 0); }
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public CommentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_comment; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterComment(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitComment(this);
    }
  }

  public final CommentContext comment() throws RecognitionException {
    CommentContext _localctx = new CommentContext(_ctx, getState());
    enterRule(_localctx, 34, RULE_comment);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(117);
      match(COMMENT_TEXT);
      setState(118);
      match(NEWLINE);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class End_of_lineContext extends ParserRuleContext {
    public CommentContext comment() {
      return getRuleContext(CommentContext.class,0);
    }
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public End_of_lineContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_end_of_line; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterEnd_of_line(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitEnd_of_line(this);
    }
  }

  public final End_of_lineContext end_of_line() throws RecognitionException {
    End_of_lineContext _localctx = new End_of_lineContext(_ctx, getState());
    enterRule(_localctx, 36, RULE_end_of_line);
    try {
      setState(122);
      switch (_input.LA(1)) {
      case COMMENT_TEXT:
        enterOuterAlt(_localctx, 1);
        {
        setState(120);
        comment();
        }
        break;
      case NEWLINE:
        enterOuterAlt(_localctx, 2);
        {
        setState(121);
        match(NEWLINE);
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\177\4\2\t\2\4"+
      "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
      "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
      "\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\3\3\3\7\3.\n\3\f\3\16\3\61"+
      "\13\3\3\3\3\3\7\3\65\n\3\f\3\16\38\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
      "\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6I\n\6\3\7\3\7\3\7\3\b\3\b\3"+
      "\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f"+
      "\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\5\16h\n\16\3\17\3\17\3\17\3\17"+
      "\3\20\3\20\5\20p\n\20\3\21\3\21\5\21t\n\21\3\22\3\22\3\23\3\23\3\23"+
      "\3\24\3\24\5\24}\n\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32"+
      "\34\36 \"$&\2\3\4\2\t\t\f\30w\2(\3\2\2\2\4+\3\2\2\2\6;\3\2\2\2\b?"+
      "\3\2\2\2\nH\3\2\2\2\fJ\3\2\2\2\16M\3\2\2\2\20Q\3\2\2\2\22U\3\2\2\2"+
      "\24Y\3\2\2\2\26\\\3\2\2\2\30`\3\2\2\2\32g\3\2\2\2\34i\3\2\2\2\36m"+
      "\3\2\2\2 q\3\2\2\2\"u\3\2\2\2$w\3\2\2\2&|\3\2\2\2()\5\4\3\2)*\7\2"+
      "\2\3*\3\3\2\2\2+/\5\6\4\2,.\5$\23\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2"+
      "\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\66\5\b\5\2\63\65\5\n\6"+
      "\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2"+
      "\28\66\3\2\2\29:\5\26\f\2:\5\3\2\2\2;<\7\3\2\2<=\7\37\2\2=>\5&\24"+
      "\2>\7\3\2\2\2?@\7\33\2\2@A\5&\24\2A\t\3\2\2\2BI\5\f\7\2CI\5\16\b\2"+
      "DI\5\20\t\2EI\5\22\n\2FI\5\24\13\2GI\5$\23\2HB\3\2\2\2HC\3\2\2\2H"+
      "D\3\2\2\2HE\3\2\2\2HF\3\2\2\2HG\3\2\2\2I\13\3\2\2\2JK\7\34\2\2KL\5"+
      "&\24\2L\r\3\2\2\2MN\7\4\2\2NO\5\30\r\2OP\5&\24\2P\17\3\2\2\2QR\7\5"+
      "\2\2RS\5\32\16\2ST\5&\24\2T\21\3\2\2\2UV\7\6\2\2VW\5\34\17\2WX\5&"+
      "\24\2X\23\3\2\2\2YZ\7\35\2\2Z[\5&\24\2[\25\3\2\2\2\\]\7\7\2\2]^\5"+
      "\36\20\2^_\5&\24\2_\27\3\2\2\2`a\7\37\2\2ab\7\b\2\2bc\7\37\2\2c\31"+
      "\3\2\2\2dh\7\t\2\2eh\7\n\2\2fh\5\30\r\2gd\3\2\2\2ge\3\2\2\2gf\3\2"+
      "\2\2h\33\3\2\2\2ij\5\30\r\2jk\7\13\2\2kl\7\37\2\2l\35\3\2\2\2mo\5"+
      " \21\2np\7\32\2\2on\3\2\2\2op\3\2\2\2p\37\3\2\2\2qs\5\"\22\2rt\7\31"+
      "\2\2sr\3\2\2\2st\3\2\2\2t!\3\2\2\2uv\t\2\2\2v#\3\2\2\2wx\7\36\2\2"+
      "xy\7 \2\2y%\3\2\2\2z}\5$\23\2{}\7 \2\2|z\3\2\2\2|{\3\2\2\2}\'\3\2"+
      "\2\2\t/\66Hgos|";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}