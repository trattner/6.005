/*
 * Compile all your grammars using
 *       java -jar ../../../lib/antlr.jar *.g4
 * then Refresh in Eclipse.
 *
 * Nonterminal rules (a.k.a. parser rules) must be lowercase, e.g. 'root' below.
 *
 * Terminal rules (a.k.a. lexical rules) must be UPPERCASE, e.g. NUMBER below.
 * Terminals can be defined with quoted strings or regular expressions.
 *
 * '^' is sharp, '_' is flat, and '=' is neutral
 *
 * A voice field might reappear in the middle of a piece, use mid-tune-field to indicate the change of a voice
 */

grammar Music;
import Configuration;

root: music EOF;
music: line+;
line: element* NEWLINE | mid_tune_field | comment;
element: note_element | tuplet_element | BARLINE | NTH_REPEAT | WHITESPACE;

note_element: note | multi_note;

note: note_or_rest note_length;
note_or_rest: pitch | REST;
pitch: ACCIDENTAL? BASENOTE OCTAVE?;
OCTAVE: '\''+ | ','+;
note_length: (DIGIT+)? ('/' (DIGIT+)?)?;

BASENOTE : [A-Ga-g];

ACCIDENTAL: '^' | '^^' | '_' | '__' | '=';
REST : 'z';

tuplet_element : tuplet_spec note_element+;
tuplet_spec : '(' DIGIT;

multi_note : '[' note+ ']';


BARLINE : '|' | '||' | '[|' | '|]' | ':|' | '|:';
NTH_REPEAT : '[1' | '[2';

mid_tune_field : VOICE_TEXT (comment | NEWLINE);
comment : COMMENT_TEXT NEWLINE;

/* Note that this allows [ \t|=/:], and that text fields can be empty */
VOICE_TEXT : 'V:' ~[%\r\n]*;
COMMENT_TEXT : '%' ~[\r\n]*;

DIGIT : [0-9];
NEWLINE : '\n' | '\r' '\n'?;
WHITESPACE : ' ' | '\t';
