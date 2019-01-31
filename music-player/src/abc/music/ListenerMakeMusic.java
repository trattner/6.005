package abc.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import abc.header.Header;
import abc.parser.MusicBaseListener;
import abc.parser.MusicParser.*;
import abc.piece.ParseException;
import abc.sound.Pitch;

public class ListenerMakeMusic extends MusicBaseListener {
    
    // Strategy and invariants: see comments on fields below
    
    public ListenerMakeMusic(Header header) {
        this.header = header;
        this.voiceBuilders = new HashMap<>();
        this.currentAccidentals = new HashMap<>();
        this.currentMultiNote = new ArrayList<>();
        this.lengthDenominators = new HashSet<>();
        
        this.currentVoice = ""; // Default voice, in case there are none specified
        this.tupletNum = 1;
        this.tupletDenom = 1;
        this.inMultiNote = false;
        
        // Make a builder for the default voice
        voiceBuilders.put(currentVoice, new VoiceBuilder());
    }
    
    // Contains information about this music
    private final Header header;
    
    // Handlers for repeats and major sections for each voice, contains Music read so far
    // for all voices yet seen in the body
    private final Map<String, VoiceBuilder> voiceBuilders;
    // Maps diatonic pitches in the key signature to the appropriate pitch in the current
    // measure, given the accidentals in the current measure (reset at end of measures)
    // Note that accidentals are octave dependent
    // Absent keys should default to the same pitch
    private final Map<Pitch, Pitch> currentAccidentals;
    // List used to store notes in a multi-note, only appended to when we have entered a
    // multi-note, and cleared when we leave a multi-note
    private final List<Music> currentMultiNote;
    // Set of all note denominators seen so far, in terms of the default note length
    // Used to compute an appropriate ticksPerBeat for playback
    private final Set<Integer> lengthDenominators;
    
    // Voice line currently being appended to, only modified when exiting a mid-tune-field
    private String currentVoice;
    // Multiplicative factor by which the duration of notes should be multiplied to create
    // a tuplet, only modified when exiting a tuplet-spec or a tuplet-element
    // These two variables represent the fraction tupletNum / tupletDenom
    private int tupletNum;
    private int tupletDenom;
    // Represents whether or not we are in a multi-note, only modified when entering or
    // leaving a multi-note 
    private boolean inMultiNote;
    
    @Override
    public void exitMid_tune_field(Mid_tune_fieldContext ctx) {
        // Starts with "V:", and possibly has trailing/leading whitespace
        String voiceWithV = ctx.VOICE_TEXT().getText();
        currentVoice = voiceWithV.substring(voiceWithV.indexOf(':') + 1).trim();
        
        if(!voiceBuilders.containsKey(currentVoice)) {
            voiceBuilders.put(currentVoice, new VoiceBuilder());
        }
    }
    
    @Override
    public void exitTuplet_spec(Tuplet_specContext ctx) {
        int spec = Integer.parseInt(ctx.DIGIT().getText());
        if(spec == 2) {
            // 2 notes in the time of 3 notes
            tupletNum = 3;
            tupletDenom = 2;
        }
        else if(spec == 3) {
            // 3 notes in the time of 2 notes
            tupletNum = 2;
            tupletDenom = 3;
        }
        else if(spec == 4) {
            // 4 notes in the time of 3 notes
            tupletNum = 3;
            tupletDenom = 4;
        }
        else {
            throw new ParseException("Invalid tuplet:" + spec);
        }
    }
    
    @Override
    public void exitTuplet_element(Tuplet_elementContext ctx) {
        // Reset tuplet factor
        tupletNum = 1;
        tupletDenom = 1;
    }
    
    @Override
    public void enterMulti_note(Multi_noteContext ctx) {
        assert !inMultiNote;
        inMultiNote = true;
    };
    
    @Override
    public void exitMulti_note(Multi_noteContext ctx) {
        assert inMultiNote;
        
        Music multiNote = new Together(currentMultiNote);
        voiceBuilders.get(currentVoice).appendMusic(multiNote);
        
        currentMultiNote.clear();
        inMultiNote = false;
    };
    
    @Override
    public void exitNote(NoteContext ctx) {
        double duration = header.getNoteLength() * tupletNum / tupletDenom;
        int denominatorOfDefault = tupletDenom;
        
        // Change duration by some modifier, if present
        if(ctx.note_length() != null) {
            String length = ctx.note_length().getText();
            int slashIndex = length.indexOf('/');
            if(slashIndex >= 0) {
                // There is a '/', which indicates a denominator
                String numerator = length.substring(0, slashIndex);
                String denominator = length.substring(slashIndex + 1);
                
                // Multiply by numerator if present
                if(!numerator.isEmpty()) {
                    duration *= Integer.parseInt(numerator);
                }
                // Divide by denominator if present, divide by 2 otherwise
                if(!denominator.isEmpty()) {
                    int parsedDenominator = Integer.parseInt(denominator);
                    duration /= parsedDenominator;
                    denominatorOfDefault *= parsedDenominator;
                }
                else {
                    duration /= 2;
                    denominatorOfDefault *= 2;
                }
            }
            else {
                // There is no '/', so we are only multiplying by some integer
                // Multiply if integer is present
                if(!length.isEmpty()) {
                    duration *= Integer.parseInt(length);
                }
            }
        }
        
        // Add the denominator in terms of the default note length to the set
        lengthDenominators.add(denominatorOfDefault);
        
        Note_or_restContext noteOrRestCtx = ctx.note_or_rest();
        
        // Music which will be added, either to a multi-note, or to the end of the active voice line
        Music toAdd;
        if(noteOrRestCtx.REST() != null) {
            // Add a rest
            toAdd = new Rest(duration);
        }
        else {
            // Add a note
            PitchContext pitchCtx = noteOrRestCtx.pitch();
            assert pitchCtx != null;
            
            String baseNote = pitchCtx.BASENOTE().getText();
            assert baseNote.length() == 1;
            
            // Get the diatonic pitch in the key signature in the octave contianing middle C
            // I.e. if C is middle C, these are in the octave CDEFGAB
            Pitch diatonicByLetter = header.getKeyMap().get(baseNote.toUpperCase());
            
            // Counts the distance, in octaves, between this note and the same note in the
            // octave contianing middle C
            int octaveDistance = 0;
            if(baseNote.toLowerCase().equals(baseNote)) {
                // Go up by one octave if note is lowercase
                octaveDistance += 1;
            }
            if(pitchCtx.OCTAVE() != null) {
                String octave = pitchCtx.OCTAVE().getText();
                if(octave.charAt(0) == '\'') {
                    // Go up some number of octaves
                    octaveDistance += octave.length();
                }
                else {
                    // Go down some number of octaves
                    assert octave.charAt(0) == ',';
                    octaveDistance -= octave.length();
                }
            }
            
            // Transpose the diatonic pitch to be in the same octave as this note
            Pitch expectedDiatonicInOctave = diatonicByLetter.transpose(octaveDistance * Pitch.OCTAVE);
            if(pitchCtx.ACCIDENTAL() != null) {
                // The note, in the correct octave, but without the accidental
                Pitch withoutAccidental = new Pitch(baseNote.toUpperCase().charAt(0))
                        .transpose(octaveDistance * Pitch.OCTAVE);
                String accidental = pitchCtx.ACCIDENTAL().getText();
                
                // Transpose by the appropriate number of semitones
                Pitch withAccidental = withoutAccidental;
                if(accidental.equals("^^")) {
                    // Double sharp
                    withAccidental = withoutAccidental.transpose(2);
                }
                else if(accidental.equals("^")) {
                    // Sharp
                    withAccidental = withoutAccidental.transpose(1);
                }
                else if(accidental.equals("_")) {
                    // Flat
                    withAccidental = withoutAccidental.transpose(-1);
                }
                else if(accidental.equals("__")) {
                    // Double flat
                    withAccidental = withoutAccidental.transpose(-2);
                }
                else {
                    // Natural (don't transpose)
                    assert accidental.equals("=");
                }
                
                // Map the diatonic pitch in this octave to the pitch with the accidental
                currentAccidentals.put(expectedDiatonicInOctave, withAccidental);
            }
            
            // Either get the pitch from the key signature, or get the pitch w/ accidental
            Pitch actualPitch = currentAccidentals.getOrDefault(
                    expectedDiatonicInOctave, expectedDiatonicInOctave);
            toAdd = new Note(duration, actualPitch);  
        }
        
        if(inMultiNote) {
            currentMultiNote.add(toAdd);
        }
        else {
            voiceBuilders.get(currentVoice).appendMusic(toAdd);
        }
    }
    
    @Override
    public void exitElement(ElementContext ctx) {
        if(ctx.BARLINE() != null) {
            voiceBuilders.get(currentVoice).processBarline(ctx.BARLINE().getText());
            // Reset accidentals for next bar
            currentAccidentals.clear();
        }
        else if(ctx.NTH_REPEAT() != null) {
            voiceBuilders.get(currentVoice).processNthRepeat(ctx.NTH_REPEAT().getText());
        }
    }

    /**
     * Collect the Music parsed by this tree walker into a single instance. This should only be called
     * once on a given ListenerMakeMusic instance.
     * @return the Music parsed by this tree walker
     */
    public Music getMusic() {
        List<Music> voiceLines = new ArrayList<>();
        for(String voice : voiceBuilders.keySet()) {
            voiceLines.add(voiceBuilders.get(voice).collect());
        }
        return new Together(voiceLines);
    }
    
    /**
     * Compute an appropriate number of ticks per beat at which this music can be played back.
     * @return a number of ticks per beat that guarantees that the duration of each note in
     * music returned by getMusic() can be expressed as an integer number of ticks.
     */
    public int getTicksPerBeat() {
        // Compute the least common multiple of the denominators seen
        int lcm = lengthDenominators.stream()
                                    .reduce(1, (a,b) -> lcm(a,b));
        // We want to be able to play 1 / (lcm * header.getBeatNumerator()) notes, so if the
        // beat has a numerator greater than 1, we should multiply by it. This might be a
        // larger number than we need, but will never be smaller than we need.
        return lcm * header.getLengthDenominator() * header.getBeatNumerator();
    }
    
    /**
     * @param a a nonnegative integer
     * @param b a nonnegative integer
     * @return the least common multiple of both a and b
     */
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    /**
     * @param a a nonnegative integer
     * @param b a nonnegative integer
     * @return the greatest common divisor of both a and b
     */
    private static int gcd(int a, int b) {
        // Recursive implementation of Euclid's algorithm
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}

/**
 * Mutable helper class for handling sections and repeats in a voice line.
 */
class VoiceBuilder {
    
    // Represents sections of Music which have been partially or completely parsed
    // The top entry on the stack represents the Music to which we are currently appending
    // When inRepeat and not inDifferentEnding, the Music on top of the stack will be repeated
    // When inRepeat and inDifferentEnding, the Music on top of the stack represents the first ending,
    // and the music below it represents the music to be repeated
    // When not in repeats, the music is divided into major sections by barlines [|, ||, |], which lets
    // us repeat back to the start of a major section when |: is omitted
    private final Stack<Music> sections;
    
    // Represents whether we have passed by a |: before a :|
    private boolean inRepeat;
    // Represents whether we have passed by a [1 before a :|
    private boolean inDifferentEnding;
    
    public VoiceBuilder() {
        sections = new Stack<>();
        sections.push(new Rest(0));
        
        inRepeat = false;
        inDifferentEnding = false;
    }
    
    /**
     * Create and/or repeat sections of music, given a barline.
     * @param barline a valid BARLINE terminal, as determined by Music.g4
     */
    public void processBarline(String barline) {
        if(barline.equals("|:")) {
            if(inRepeat || inDifferentEnding){
                // Being in a different ending implies we had something of the form
                // [1 ... |: ... :| ... :|[2, which only makes sense with nested repeats
                throw new ParseException("Nested repeats not allowed");
            }
            else {
                // Declare that we are in a repeat and declare a new section
                inRepeat = true;
                sections.push(new Rest(0));
            }
        }
        else if(barline.equals(":|")) {
            if(inDifferentEnding) {
                assert sections.size() >= 2;
                
                // First ending is top entry on the stack
                // Music to repeat is next entry on the stack
                Music firstEnding = sections.pop();
                Music toRepeat = sections.peek();
                
                // Play the ending before playing the music to repeat
                sections.push(firstEnding);
                sections.push(toRepeat);
            }
            else {
                assert sections.size() >= 1;
                
                // Music to repeat is top entry on the stack
                Music toRepeat = sections.peek();
                sections.push(toRepeat);
            }
            
            // Leave the repeat, create a new section
            inRepeat = false;
            inDifferentEnding = false;
            sections.push(new Rest(0));
        }
        else if(barline.equals("[|") || barline.equals("||") || barline.equals("|]")) {
            // We are in a new section. Formally, we only treat it as a new section if
            // not in a repeat. This is because we want to treat everything from |: to
            // either [1 or :| as a single section, so we may repeat it.
            if(!inRepeat) {
                if(inDifferentEnding) {
                    throw new ParseException("[1 found but section ended before :|");
                }
                // Create a new section
                sections.push(new Rest(0));
            }
            // else do nothing when inRepeat
        }
        else {
            assert barline.equals("|") : "invalid barline: " + barline;
            // Do nothing; these barlines are ignored
        }
    }
    
    /**
     * Create and/or repeat sections of music, given an nth-repeat
     * @param nthRepeat a valid NTH_REPEAT terminal, as determined by Music.g4
     */
    public void processNthRepeat(String nthRepeat) {
        if(nthRepeat.equals("[1")) {
            // Declare that we are now expecting a second ending. End the current
            // section (which will be repeated), and create a new section, representing
            // the first ending.
            inDifferentEnding = true;
            sections.push(new Rest(0));
        }
        else {
            assert nthRepeat.equals("[2") : "invalid nth-repeat: " + nthRepeat;
            if(inRepeat){
                throw new ParseException("[2 found after |: but before :|");
            }
            if(inDifferentEnding) {
                throw new ParseException("[2 found after [1 but before :|");
            }
            // Do nothing because we already created a new section when we got to :|
        }
    }
    
    /**
     * Concatenate the music in this builder with the selected music.
     * @param music music to append
     */
    public void appendMusic(Music music) {
        assert sections.size() >= 1;
        Music section = sections.pop();
        sections.push(new Concat(section, music));
    }
    
    /**
     * Build a single music instance containing all of the music of this builder.
     * After calling this method, results of subsequent calls to methods of this
     * builder are undefined. Thus, this method should only be called once on an
     * instance, when all music has been appended.
     * @return the music in this builder collected into a single instance
     */
    public Music collect() {
        assert sections.size() >= 1;
        
        Music current = sections.pop();
        while(!sections.empty()) {
            // The topmost entries on the stack are music that should be played last
            current = new Concat(sections.pop(), current);
        }
        
        return current;
    }
}
