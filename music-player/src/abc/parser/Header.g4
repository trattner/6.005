/*
 * Compile all your grammars using
 *       java -jar ../../../lib/antlr.jar *.g4
 * then Refresh in Eclipse.
 */
grammar Header;
import Configuration;

root: header EOF;
header: field_number comment* field_title other_fields* field_key;

field_number: 'X:' DIGITS end_of_line;
field_title: TITLE_TEXT end_of_line;
other_fields: field_composer | field_default_length | field_meter | field_tempo | field_voice | comment;
field_composer: COMPOSER_TEXT end_of_line;
field_default_length: 'L:' fraction end_of_line;
field_meter: 'M:' meter end_of_line;
field_tempo: 'Q:' tempo end_of_line;
field_voice: VOICE_TEXT end_of_line;
field_key: 'K:' key end_of_line;

fraction: DIGITS '/' DIGITS;
meter: 'C' | 'C|' | fraction;
tempo: fraction '=' DIGITS;

key: keynote MODE_MINOR?;
keynote: basenote KEY_ACCIDENTAL?;
KEY_ACCIDENTAL: '#' | 'b';
basenote: 'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'G' | 'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g';
MODE_MINOR: 'm';

comment: COMMENT_TEXT NEWLINE;
end_of_line: comment | NEWLINE;

/* Note that this allows [ \t|=/:], and that text fields can be empty */
TITLE_TEXT: 'T:' ~[%\r\n]*;
COMPOSER_TEXT: 'C:' ~[%\r\n]*;
VOICE_TEXT: 'V:' ~[%\r\n]*;
COMMENT_TEXT: '%' ~[\r\n]*;

DIGITS: [0-9]+;
NEWLINE: '\n' | '\r' '\n'?;

/* Ignore whitespace between terminals */
WHITESPACE : [ \t]+ -> skip;
