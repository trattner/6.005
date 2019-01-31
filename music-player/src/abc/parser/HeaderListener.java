// Generated from Header.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HeaderParser}.
 */
public interface HeaderListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link HeaderParser#root}.
   * @param ctx the parse tree
   */
  void enterRoot(HeaderParser.RootContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#root}.
   * @param ctx the parse tree
   */
  void exitRoot(HeaderParser.RootContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#header}.
   * @param ctx the parse tree
   */
  void enterHeader(HeaderParser.HeaderContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#header}.
   * @param ctx the parse tree
   */
  void exitHeader(HeaderParser.HeaderContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#field_number}.
   * @param ctx the parse tree
   */
  void enterField_number(HeaderParser.Field_numberContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#field_number}.
   * @param ctx the parse tree
   */
  void exitField_number(HeaderParser.Field_numberContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#field_title}.
   * @param ctx the parse tree
   */
  void enterField_title(HeaderParser.Field_titleContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#field_title}.
   * @param ctx the parse tree
   */
  void exitField_title(HeaderParser.Field_titleContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#other_fields}.
   * @param ctx the parse tree
   */
  void enterOther_fields(HeaderParser.Other_fieldsContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#other_fields}.
   * @param ctx the parse tree
   */
  void exitOther_fields(HeaderParser.Other_fieldsContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#field_composer}.
   * @param ctx the parse tree
   */
  void enterField_composer(HeaderParser.Field_composerContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#field_composer}.
   * @param ctx the parse tree
   */
  void exitField_composer(HeaderParser.Field_composerContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#field_default_length}.
   * @param ctx the parse tree
   */
  void enterField_default_length(HeaderParser.Field_default_lengthContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#field_default_length}.
   * @param ctx the parse tree
   */
  void exitField_default_length(HeaderParser.Field_default_lengthContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#field_meter}.
   * @param ctx the parse tree
   */
  void enterField_meter(HeaderParser.Field_meterContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#field_meter}.
   * @param ctx the parse tree
   */
  void exitField_meter(HeaderParser.Field_meterContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#field_tempo}.
   * @param ctx the parse tree
   */
  void enterField_tempo(HeaderParser.Field_tempoContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#field_tempo}.
   * @param ctx the parse tree
   */
  void exitField_tempo(HeaderParser.Field_tempoContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#field_voice}.
   * @param ctx the parse tree
   */
  void enterField_voice(HeaderParser.Field_voiceContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#field_voice}.
   * @param ctx the parse tree
   */
  void exitField_voice(HeaderParser.Field_voiceContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#field_key}.
   * @param ctx the parse tree
   */
  void enterField_key(HeaderParser.Field_keyContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#field_key}.
   * @param ctx the parse tree
   */
  void exitField_key(HeaderParser.Field_keyContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#fraction}.
   * @param ctx the parse tree
   */
  void enterFraction(HeaderParser.FractionContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#fraction}.
   * @param ctx the parse tree
   */
  void exitFraction(HeaderParser.FractionContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#meter}.
   * @param ctx the parse tree
   */
  void enterMeter(HeaderParser.MeterContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#meter}.
   * @param ctx the parse tree
   */
  void exitMeter(HeaderParser.MeterContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#tempo}.
   * @param ctx the parse tree
   */
  void enterTempo(HeaderParser.TempoContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#tempo}.
   * @param ctx the parse tree
   */
  void exitTempo(HeaderParser.TempoContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#key}.
   * @param ctx the parse tree
   */
  void enterKey(HeaderParser.KeyContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#key}.
   * @param ctx the parse tree
   */
  void exitKey(HeaderParser.KeyContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#keynote}.
   * @param ctx the parse tree
   */
  void enterKeynote(HeaderParser.KeynoteContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#keynote}.
   * @param ctx the parse tree
   */
  void exitKeynote(HeaderParser.KeynoteContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#basenote}.
   * @param ctx the parse tree
   */
  void enterBasenote(HeaderParser.BasenoteContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#basenote}.
   * @param ctx the parse tree
   */
  void exitBasenote(HeaderParser.BasenoteContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#comment}.
   * @param ctx the parse tree
   */
  void enterComment(HeaderParser.CommentContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#comment}.
   * @param ctx the parse tree
   */
  void exitComment(HeaderParser.CommentContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#end_of_line}.
   * @param ctx the parse tree
   */
  void enterEnd_of_line(HeaderParser.End_of_lineContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#end_of_line}.
   * @param ctx the parse tree
   */
  void exitEnd_of_line(HeaderParser.End_of_lineContext ctx);
}