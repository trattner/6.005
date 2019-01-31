// Generated from Music.g4 by ANTLR 4.5.1

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
public class MusicParser extends Parser {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, OCTAVE=5, BASENOTE=6, ACCIDENTAL=7, 
    REST=8, BARLINE=9, NTH_REPEAT=10, VOICE_TEXT=11, COMMENT_TEXT=12, DIGIT=13, 
    NEWLINE=14, WHITESPACE=15;
  public static final int
    RULE_root = 0, RULE_music = 1, RULE_line = 2, RULE_element = 3, RULE_note_element = 4, 
    RULE_note = 5, RULE_note_or_rest = 6, RULE_pitch = 7, RULE_note_length = 8, 
    RULE_tuplet_element = 9, RULE_tuplet_spec = 10, RULE_multi_note = 11, 
    RULE_mid_tune_field = 12, RULE_comment = 13;
  public static final String[] ruleNames = {
    "root", "music", "line", "element", "note_element", "note", "note_or_rest", 
    "pitch", "note_length", "tuplet_element", "tuplet_spec", "multi_note", 
    "mid_tune_field", "comment"
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

  @Override
  public String getGrammarFileName() { return "Music.g4"; }

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

  public MusicParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class RootContext extends ParserRuleContext {
    public MusicContext music() {
      return getRuleContext(MusicContext.class,0);
    }
    public TerminalNode EOF() { return getToken(MusicParser.EOF, 0); }
    public RootContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_root; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterRoot(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitRoot(this);
    }
  }

  public final RootContext root() throws RecognitionException {
    RootContext _localctx = new RootContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_root);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(28);
      music();
      setState(29);
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

  public static class MusicContext extends ParserRuleContext {
    public List<LineContext> line() {
      return getRuleContexts(LineContext.class);
    }
    public LineContext line(int i) {
      return getRuleContext(LineContext.class,i);
    }
    public MusicContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_music; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterMusic(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitMusic(this);
    }
  }

  public final MusicContext music() throws RecognitionException {
    MusicContext _localctx = new MusicContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_music);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(32); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(31);
        line();
        }
        }
        setState(34); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << BASENOTE) | (1L << ACCIDENTAL) | (1L << REST) | (1L << BARLINE) | (1L << NTH_REPEAT) | (1L << VOICE_TEXT) | (1L << COMMENT_TEXT) | (1L << NEWLINE) | (1L << WHITESPACE))) != 0) );
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

  public static class LineContext extends ParserRuleContext {
    public TerminalNode NEWLINE() { return getToken(MusicParser.NEWLINE, 0); }
    public List<ElementContext> element() {
      return getRuleContexts(ElementContext.class);
    }
    public ElementContext element(int i) {
      return getRuleContext(ElementContext.class,i);
    }
    public Mid_tune_fieldContext mid_tune_field() {
      return getRuleContext(Mid_tune_fieldContext.class,0);
    }
    public CommentContext comment() {
      return getRuleContext(CommentContext.class,0);
    }
    public LineContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_line; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterLine(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitLine(this);
    }
  }

  public final LineContext line() throws RecognitionException {
    LineContext _localctx = new LineContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_line);
    int _la;
    try {
      setState(45);
      switch (_input.LA(1)) {
      case T__1:
      case T__2:
      case BASENOTE:
      case ACCIDENTAL:
      case REST:
      case BARLINE:
      case NTH_REPEAT:
      case NEWLINE:
      case WHITESPACE:
        enterOuterAlt(_localctx, 1);
        {
        setState(39);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << BASENOTE) | (1L << ACCIDENTAL) | (1L << REST) | (1L << BARLINE) | (1L << NTH_REPEAT) | (1L << WHITESPACE))) != 0)) {
          {
          {
          setState(36);
          element();
          }
          }
          setState(41);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(42);
        match(NEWLINE);
        }
        break;
      case VOICE_TEXT:
        enterOuterAlt(_localctx, 2);
        {
        setState(43);
        mid_tune_field();
        }
        break;
      case COMMENT_TEXT:
        enterOuterAlt(_localctx, 3);
        {
        setState(44);
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

  public static class ElementContext extends ParserRuleContext {
    public Note_elementContext note_element() {
      return getRuleContext(Note_elementContext.class,0);
    }
    public Tuplet_elementContext tuplet_element() {
      return getRuleContext(Tuplet_elementContext.class,0);
    }
    public TerminalNode BARLINE() { return getToken(MusicParser.BARLINE, 0); }
    public TerminalNode NTH_REPEAT() { return getToken(MusicParser.NTH_REPEAT, 0); }
    public TerminalNode WHITESPACE() { return getToken(MusicParser.WHITESPACE, 0); }
    public ElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_element; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterElement(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitElement(this);
    }
  }

  public final ElementContext element() throws RecognitionException {
    ElementContext _localctx = new ElementContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_element);
    try {
      setState(52);
      switch (_input.LA(1)) {
      case T__2:
      case BASENOTE:
      case ACCIDENTAL:
      case REST:
        enterOuterAlt(_localctx, 1);
        {
        setState(47);
        note_element();
        }
        break;
      case T__1:
        enterOuterAlt(_localctx, 2);
        {
        setState(48);
        tuplet_element();
        }
        break;
      case BARLINE:
        enterOuterAlt(_localctx, 3);
        {
        setState(49);
        match(BARLINE);
        }
        break;
      case NTH_REPEAT:
        enterOuterAlt(_localctx, 4);
        {
        setState(50);
        match(NTH_REPEAT);
        }
        break;
      case WHITESPACE:
        enterOuterAlt(_localctx, 5);
        {
        setState(51);
        match(WHITESPACE);
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

  public static class Note_elementContext extends ParserRuleContext {
    public NoteContext note() {
      return getRuleContext(NoteContext.class,0);
    }
    public Multi_noteContext multi_note() {
      return getRuleContext(Multi_noteContext.class,0);
    }
    public Note_elementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note_element; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterNote_element(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitNote_element(this);
    }
  }

  public final Note_elementContext note_element() throws RecognitionException {
    Note_elementContext _localctx = new Note_elementContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_note_element);
    try {
      setState(56);
      switch (_input.LA(1)) {
      case BASENOTE:
      case ACCIDENTAL:
      case REST:
        enterOuterAlt(_localctx, 1);
        {
        setState(54);
        note();
        }
        break;
      case T__2:
        enterOuterAlt(_localctx, 2);
        {
        setState(55);
        multi_note();
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

  public static class NoteContext extends ParserRuleContext {
    public Note_or_restContext note_or_rest() {
      return getRuleContext(Note_or_restContext.class,0);
    }
    public Note_lengthContext note_length() {
      return getRuleContext(Note_lengthContext.class,0);
    }
    public NoteContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterNote(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitNote(this);
    }
  }

  public final NoteContext note() throws RecognitionException {
    NoteContext _localctx = new NoteContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_note);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(58);
      note_or_rest();
      setState(59);
      note_length();
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

  public static class Note_or_restContext extends ParserRuleContext {
    public PitchContext pitch() {
      return getRuleContext(PitchContext.class,0);
    }
    public TerminalNode REST() { return getToken(MusicParser.REST, 0); }
    public Note_or_restContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note_or_rest; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterNote_or_rest(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitNote_or_rest(this);
    }
  }

  public final Note_or_restContext note_or_rest() throws RecognitionException {
    Note_or_restContext _localctx = new Note_or_restContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_note_or_rest);
    try {
      setState(63);
      switch (_input.LA(1)) {
      case BASENOTE:
      case ACCIDENTAL:
        enterOuterAlt(_localctx, 1);
        {
        setState(61);
        pitch();
        }
        break;
      case REST:
        enterOuterAlt(_localctx, 2);
        {
        setState(62);
        match(REST);
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

  public static class PitchContext extends ParserRuleContext {
    public TerminalNode BASENOTE() { return getToken(MusicParser.BASENOTE, 0); }
    public TerminalNode ACCIDENTAL() { return getToken(MusicParser.ACCIDENTAL, 0); }
    public TerminalNode OCTAVE() { return getToken(MusicParser.OCTAVE, 0); }
    public PitchContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_pitch; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterPitch(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitPitch(this);
    }
  }

  public final PitchContext pitch() throws RecognitionException {
    PitchContext _localctx = new PitchContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_pitch);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(66);
      _la = _input.LA(1);
      if (_la==ACCIDENTAL) {
        {
        setState(65);
        match(ACCIDENTAL);
        }
      }

      setState(68);
      match(BASENOTE);
      setState(70);
      _la = _input.LA(1);
      if (_la==OCTAVE) {
        {
        setState(69);
        match(OCTAVE);
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

  public static class Note_lengthContext extends ParserRuleContext {
    public List<TerminalNode> DIGIT() { return getTokens(MusicParser.DIGIT); }
    public TerminalNode DIGIT(int i) {
      return getToken(MusicParser.DIGIT, i);
    }
    public Note_lengthContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note_length; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterNote_length(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitNote_length(this);
    }
  }

  public final Note_lengthContext note_length() throws RecognitionException {
    Note_lengthContext _localctx = new Note_lengthContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_note_length);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(77);
      _la = _input.LA(1);
      if (_la==DIGIT) {
        {
        setState(73); 
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
          {
          setState(72);
          match(DIGIT);
          }
          }
          setState(75); 
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while ( _la==DIGIT );
        }
      }

      setState(87);
      _la = _input.LA(1);
      if (_la==T__0) {
        {
        setState(79);
        match(T__0);
        setState(85);
        _la = _input.LA(1);
        if (_la==DIGIT) {
          {
          setState(81); 
          _errHandler.sync(this);
          _la = _input.LA(1);
          do {
            {
            {
            setState(80);
            match(DIGIT);
            }
            }
            setState(83); 
            _errHandler.sync(this);
            _la = _input.LA(1);
          } while ( _la==DIGIT );
          }
        }

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

  public static class Tuplet_elementContext extends ParserRuleContext {
    public Tuplet_specContext tuplet_spec() {
      return getRuleContext(Tuplet_specContext.class,0);
    }
    public List<Note_elementContext> note_element() {
      return getRuleContexts(Note_elementContext.class);
    }
    public Note_elementContext note_element(int i) {
      return getRuleContext(Note_elementContext.class,i);
    }
    public Tuplet_elementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_tuplet_element; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterTuplet_element(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitTuplet_element(this);
    }
  }

  public final Tuplet_elementContext tuplet_element() throws RecognitionException {
    Tuplet_elementContext _localctx = new Tuplet_elementContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_tuplet_element);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(89);
      tuplet_spec();
      setState(91); 
      _errHandler.sync(this);
      _alt = 1;
      do {
        switch (_alt) {
        case 1:
          {
          {
          setState(90);
          note_element();
          }
          }
          break;
        default:
          throw new NoViableAltException(this);
        }
        setState(93); 
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,13,_ctx);
      } while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

  public static class Tuplet_specContext extends ParserRuleContext {
    public TerminalNode DIGIT() { return getToken(MusicParser.DIGIT, 0); }
    public Tuplet_specContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_tuplet_spec; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterTuplet_spec(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitTuplet_spec(this);
    }
  }

  public final Tuplet_specContext tuplet_spec() throws RecognitionException {
    Tuplet_specContext _localctx = new Tuplet_specContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_tuplet_spec);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(95);
      match(T__1);
      setState(96);
      match(DIGIT);
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

  public static class Multi_noteContext extends ParserRuleContext {
    public List<NoteContext> note() {
      return getRuleContexts(NoteContext.class);
    }
    public NoteContext note(int i) {
      return getRuleContext(NoteContext.class,i);
    }
    public Multi_noteContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_multi_note; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterMulti_note(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitMulti_note(this);
    }
  }

  public final Multi_noteContext multi_note() throws RecognitionException {
    Multi_noteContext _localctx = new Multi_noteContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_multi_note);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(98);
      match(T__2);
      setState(100); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(99);
        note();
        }
        }
        setState(102); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BASENOTE) | (1L << ACCIDENTAL) | (1L << REST))) != 0) );
      setState(104);
      match(T__3);
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

  public static class Mid_tune_fieldContext extends ParserRuleContext {
    public TerminalNode VOICE_TEXT() { return getToken(MusicParser.VOICE_TEXT, 0); }
    public CommentContext comment() {
      return getRuleContext(CommentContext.class,0);
    }
    public TerminalNode NEWLINE() { return getToken(MusicParser.NEWLINE, 0); }
    public Mid_tune_fieldContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_mid_tune_field; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterMid_tune_field(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitMid_tune_field(this);
    }
  }

  public final Mid_tune_fieldContext mid_tune_field() throws RecognitionException {
    Mid_tune_fieldContext _localctx = new Mid_tune_fieldContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_mid_tune_field);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(106);
      match(VOICE_TEXT);
      setState(109);
      switch (_input.LA(1)) {
      case COMMENT_TEXT:
        {
        setState(107);
        comment();
        }
        break;
      case NEWLINE:
        {
        setState(108);
        match(NEWLINE);
        }
        break;
      default:
        throw new NoViableAltException(this);
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
    public TerminalNode COMMENT_TEXT() { return getToken(MusicParser.COMMENT_TEXT, 0); }
    public TerminalNode NEWLINE() { return getToken(MusicParser.NEWLINE, 0); }
    public CommentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_comment; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterComment(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitComment(this);
    }
  }

  public final CommentContext comment() throws RecognitionException {
    CommentContext _localctx = new CommentContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_comment);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(111);
      match(COMMENT_TEXT);
      setState(112);
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

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21u\4\2\t\2\4\3"+
      "\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
      "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\3\6\3#\n\3"+
      "\r\3\16\3$\3\4\7\4(\n\4\f\4\16\4+\13\4\3\4\3\4\3\4\5\4\60\n\4\3\5"+
      "\3\5\3\5\3\5\3\5\5\5\67\n\5\3\6\3\6\5\6;\n\6\3\7\3\7\3\7\3\b\3\b\5"+
      "\bB\n\b\3\t\5\tE\n\t\3\t\3\t\5\tI\n\t\3\n\6\nL\n\n\r\n\16\nM\5\nP"+
      "\n\n\3\n\3\n\6\nT\n\n\r\n\16\nU\5\nX\n\n\5\nZ\n\n\3\13\3\13\6\13^"+
      "\n\13\r\13\16\13_\3\f\3\f\3\f\3\r\3\r\6\rg\n\r\r\r\16\rh\3\r\3\r\3"+
      "\16\3\16\3\16\5\16p\n\16\3\17\3\17\3\17\3\17\2\2\20\2\4\6\b\n\f\16"+
      "\20\22\24\26\30\32\34\2\2z\2\36\3\2\2\2\4\"\3\2\2\2\6/\3\2\2\2\b\66"+
      "\3\2\2\2\n:\3\2\2\2\f<\3\2\2\2\16A\3\2\2\2\20D\3\2\2\2\22O\3\2\2\2"+
      "\24[\3\2\2\2\26a\3\2\2\2\30d\3\2\2\2\32l\3\2\2\2\34q\3\2\2\2\36\37"+
      "\5\4\3\2\37 \7\2\2\3 \3\3\2\2\2!#\5\6\4\2\"!\3\2\2\2#$\3\2\2\2$\""+
      "\3\2\2\2$%\3\2\2\2%\5\3\2\2\2&(\5\b\5\2\'&\3\2\2\2(+\3\2\2\2)\'\3"+
      "\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,\60\7\20\2\2-\60\5\32\16\2.\60"+
      "\5\34\17\2/)\3\2\2\2/-\3\2\2\2/.\3\2\2\2\60\7\3\2\2\2\61\67\5\n\6"+
      "\2\62\67\5\24\13\2\63\67\7\13\2\2\64\67\7\f\2\2\65\67\7\21\2\2\66"+
      "\61\3\2\2\2\66\62\3\2\2\2\66\63\3\2\2\2\66\64\3\2\2\2\66\65\3\2\2"+
      "\2\67\t\3\2\2\28;\5\f\7\29;\5\30\r\2:8\3\2\2\2:9\3\2\2\2;\13\3\2\2"+
      "\2<=\5\16\b\2=>\5\22\n\2>\r\3\2\2\2?B\5\20\t\2@B\7\n\2\2A?\3\2\2\2"+
      "A@\3\2\2\2B\17\3\2\2\2CE\7\t\2\2DC\3\2\2\2DE\3\2\2\2EF\3\2\2\2FH\7"+
      "\b\2\2GI\7\7\2\2HG\3\2\2\2HI\3\2\2\2I\21\3\2\2\2JL\7\17\2\2KJ\3\2"+
      "\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OK\3\2\2\2OP\3\2\2\2P"+
      "Y\3\2\2\2QW\7\3\2\2RT\7\17\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2"+
      "\2\2VX\3\2\2\2WS\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YQ\3\2\2\2YZ\3\2\2\2Z"+
      "\23\3\2\2\2[]\5\26\f\2\\^\5\n\6\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_"+
      "`\3\2\2\2`\25\3\2\2\2ab\7\4\2\2bc\7\17\2\2c\27\3\2\2\2df\7\5\2\2e"+
      "g\5\f\7\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2ij\3\2\2\2jk\7\6"+
      "\2\2k\31\3\2\2\2lo\7\r\2\2mp\5\34\17\2np\7\20\2\2om\3\2\2\2on\3\2"+
      "\2\2p\33\3\2\2\2qr\7\16\2\2rs\7\20\2\2s\35\3\2\2\2\22$)/\66:ADHMO"+
      "UWY_ho";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}