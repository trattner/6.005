// Generated from Music.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MusicParser}.
 */
public interface MusicListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link MusicParser#root}.
   * @param ctx the parse tree
   */
  void enterRoot(MusicParser.RootContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#root}.
   * @param ctx the parse tree
   */
  void exitRoot(MusicParser.RootContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#music}.
   * @param ctx the parse tree
   */
  void enterMusic(MusicParser.MusicContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#music}.
   * @param ctx the parse tree
   */
  void exitMusic(MusicParser.MusicContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#line}.
   * @param ctx the parse tree
   */
  void enterLine(MusicParser.LineContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#line}.
   * @param ctx the parse tree
   */
  void exitLine(MusicParser.LineContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#element}.
   * @param ctx the parse tree
   */
  void enterElement(MusicParser.ElementContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#element}.
   * @param ctx the parse tree
   */
  void exitElement(MusicParser.ElementContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#note_element}.
   * @param ctx the parse tree
   */
  void enterNote_element(MusicParser.Note_elementContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#note_element}.
   * @param ctx the parse tree
   */
  void exitNote_element(MusicParser.Note_elementContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#note}.
   * @param ctx the parse tree
   */
  void enterNote(MusicParser.NoteContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#note}.
   * @param ctx the parse tree
   */
  void exitNote(MusicParser.NoteContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#note_or_rest}.
   * @param ctx the parse tree
   */
  void enterNote_or_rest(MusicParser.Note_or_restContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#note_or_rest}.
   * @param ctx the parse tree
   */
  void exitNote_or_rest(MusicParser.Note_or_restContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#pitch}.
   * @param ctx the parse tree
   */
  void enterPitch(MusicParser.PitchContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#pitch}.
   * @param ctx the parse tree
   */
  void exitPitch(MusicParser.PitchContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#note_length}.
   * @param ctx the parse tree
   */
  void enterNote_length(MusicParser.Note_lengthContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#note_length}.
   * @param ctx the parse tree
   */
  void exitNote_length(MusicParser.Note_lengthContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#tuplet_element}.
   * @param ctx the parse tree
   */
  void enterTuplet_element(MusicParser.Tuplet_elementContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#tuplet_element}.
   * @param ctx the parse tree
   */
  void exitTuplet_element(MusicParser.Tuplet_elementContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#tuplet_spec}.
   * @param ctx the parse tree
   */
  void enterTuplet_spec(MusicParser.Tuplet_specContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#tuplet_spec}.
   * @param ctx the parse tree
   */
  void exitTuplet_spec(MusicParser.Tuplet_specContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#multi_note}.
   * @param ctx the parse tree
   */
  void enterMulti_note(MusicParser.Multi_noteContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#multi_note}.
   * @param ctx the parse tree
   */
  void exitMulti_note(MusicParser.Multi_noteContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#mid_tune_field}.
   * @param ctx the parse tree
   */
  void enterMid_tune_field(MusicParser.Mid_tune_fieldContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#mid_tune_field}.
   * @param ctx the parse tree
   */
  void exitMid_tune_field(MusicParser.Mid_tune_fieldContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#comment}.
   * @param ctx the parse tree
   */
  void enterComment(MusicParser.CommentContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#comment}.
   * @param ctx the parse tree
   */
  void exitComment(MusicParser.CommentContext ctx);
}