package abc.music;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

import abc.sound.Pitch;
import abc.sound.SequencePlayer;

/**
 * Tests for Music
 */
public class MusicTest {
    
    /*
     * Testing strategy
     * 
     * Music partitions, used to test all methods:
     *   music is a note, rest, concat, together
     *   music depth is 1, 2, >2
     *       notes, rests have depth 1
     *       concats, togethers have depth 1 greater than their arguments
     * 
     * Additional partitions for specific methods:
     *   equals():
     *     that is equal, same notes but not structurally equal, not equal
     *   duration():
     *     result is 0, >0
     *   queue():
     *     atBeat is 0, >0
     * 
     * Other strategies:
     *   verify that toString and hashCode are equal for equal Music
     *   test queue() using comparePlayerLines() below
     */
    
    public static final double TOLERANCE = 0.0001;
    public static final int DEFAULT_BPM = 100;
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    /**
     * Assert that the selected player contains the correct set of events, in any order.
     * @param player sequence player to test
     * @param expectedLines lines expected in player.toString()
     */
    private void comparePlayerLines(SequencePlayer player, String[] expectedLines) {
        Set<String> expectedLinesSet = new HashSet<>(
                Arrays.asList(expectedLines)
        );
        Set<String> actualLinesSet = new HashSet<>(
                Arrays.asList(player.toString().split("\n"))
        );
        assertEquals("expected correct music queueing", expectedLinesSet, actualLinesSet);
    }
    
    // Tests note, depth 1
    @Test
    public void testNote() throws MidiUnavailableException, InvalidMidiDataException {
        Music m1 = new Note(1, new Pitch('C'));
        Music m2 = new Note(1, new Pitch('C'));
        Music m3 = new Note(2, new Pitch('C'));
        Music m4 = new Note(1, new Pitch('D'));
        SequencePlayer player = new SequencePlayer(DEFAULT_BPM, 2);
        
        // Tests equals: equal
        assertEquals("expected equal music", m1, m2);
        assertEquals("expected equal hashCode", m1.hashCode(), m2.hashCode());
        assertEquals("expected equal toString", m1.toString(), m2.toString());
        
        // Test equals: not equal
        assertNotEquals("expected inequal music", m1, m3);
        assertNotEquals("expected inequal music", m1, m4);
        
        // Tests duration: duration > 0
        assertEquals("expected correct duration", 1, m1.duration(), TOLERANCE);
        
        // Tests toString
        assertEquals("expected correct toString", "Note(1.0,C)", m1.toString());
        
        // Tests queue: atBeat = 0
        m1.queue(player, 0);
        String[] expectedLines = new String[] {
                "Event: NOTE_ON  Pitch: 60  Tick: 0",
                "Event: NOTE_OFF Pitch: 60  Tick: 2",
                "Meta event: END_OF_TRACK Tick: 2"
        };
        comparePlayerLines(player, expectedLines);
    }
    
    // Tests rest, depth 1
    @Test
    public void testRest() throws MidiUnavailableException, InvalidMidiDataException {
        Music m1 = new Rest(0);
        Music m2 = new Rest(0);
        Music m3 = new Rest(2.5);
        SequencePlayer player = new SequencePlayer(DEFAULT_BPM, 2);
        
        // Tests equals: equal
        assertEquals("expected equal music", m1, m2);
        assertEquals("expected equal hashCode", m1.hashCode(), m2.hashCode());
        assertEquals("expected equal toString", m1.toString(), m2.toString());
        
        // Tests equals: not equal
        assertNotEquals("expected inequal music", m1, m3);
        
        // Tests duration: duration = 0
        assertEquals("expected correct duration", 0, m1.duration(), TOLERANCE);
        
        // Tests toString
        assertEquals("expected correct toString", "Rest(0.0)", m1.toString());
        
        // Tests queue: atBeat = 0
        m1.queue(player, 0);
        String[] expectedLines = new String[] {
                "Meta event: END_OF_TRACK Tick: 0"
        };
        comparePlayerLines(player, expectedLines);
    }
    
    // Tests concat, depth 2
    @Test
    public void testConcat() throws MidiUnavailableException, InvalidMidiDataException {
        Music m1 = new Concat(
                new Note(0.5, new Pitch('A')),
                new Note(1.5, new Pitch('B'))
        );
        Music m2 = new Concat(
                new Note(0.5, new Pitch('A')),
                new Note(1.5, new Pitch('B'))
        );
        Music m3 = new Concat(
                new Note(1.5, new Pitch('B')),
                new Note(0.5, new Pitch('A'))
        );
        SequencePlayer player = new SequencePlayer(DEFAULT_BPM, 2);
        
        // Tests equals: equal
        assertEquals("expected equal music", m1, m2);
        assertEquals("expected equal hashCode", m1.hashCode(), m2.hashCode());
        assertEquals("expected equal toString", m1.toString(), m2.toString());
        
        // Tests equals: not equal
        assertNotEquals("expected inequal music", m1, m3);
        
        // Tests duration: duration > 0
        assertEquals("expected correct duration", 2, m1.duration(), TOLERANCE);
        
        // Tests toString
        assertEquals("expected correct toString", "Concat(Note(0.5,A),Note(1.5,B))", m1.toString());
        
        // Tests queue: atBeat > 0
        m1.queue(player, 3);
        String[] expectedLines = new String[] {
                "Event: NOTE_ON  Pitch: 69  Tick: 6",
                "Event: NOTE_OFF Pitch: 69  Tick: 7",
                "Event: NOTE_ON  Pitch: 71  Tick: 7",
                "Event: NOTE_OFF Pitch: 71  Tick: 10",
                "Meta event: END_OF_TRACK Tick: 10"
        };
        comparePlayerLines(player, expectedLines);
    }
    
    // Tests together, depth 2
    @Test
    public void testTogether() throws MidiUnavailableException, InvalidMidiDataException {
        Music m1 = new Together(Arrays.asList(
                new Note(0.5, new Pitch('A')),
                new Note(1.5, new Pitch('B'))
        ));
        Music m2 = new Together(Arrays.asList(
                new Note(0.5, new Pitch('A')),
                new Note(1.5, new Pitch('B'))
        ));
        Music m3 = new Together(Arrays.asList(
                new Note(1.5, new Pitch('B')),
                new Note(0.5, new Pitch('A'))
        ));
        SequencePlayer player = new SequencePlayer(DEFAULT_BPM, 2);
        
        // Tests equals: equal
        assertEquals("expected equal music", m1, m2);
        assertEquals("expected equal hashCode", m1.hashCode(), m2.hashCode());
        assertEquals("expected equal toString", m1.toString(), m2.toString());
        
        // Tests equals: not equal
        assertNotEquals("expected inequal music", m1, m3);
        
        // Tests duration: duration > 0
        assertEquals("expected correct duration", 0.5, m1.duration(), TOLERANCE);
        
        // Tests toString
        assertEquals("expected correct toString", "Together([Note(0.5,A), Note(1.5,B)])", m1.toString());
        
        // Tests queue: atBeat > 0
        m1.queue(player, 5);
        String[] expectedLines = new String[] {
                "Event: NOTE_ON  Pitch: 69  Tick: 10",
                "Event: NOTE_ON  Pitch: 71  Tick: 10",
                "Event: NOTE_OFF Pitch: 69  Tick: 11",
                "Event: NOTE_OFF Pitch: 71  Tick: 13",
                "Meta event: END_OF_TRACK Tick: 13"
        };
        comparePlayerLines(player, expectedLines);
    }
    
    // Tests together, depth > 2
    @Test
    public void testComplexMusic() throws MidiUnavailableException, InvalidMidiDataException {
        Music e = new Note(1.5, new Pitch('E'));
        Music f = new Note(0.5, new Pitch('F'));
        Music ef = new Concat(e, f);
        Music efef = new Concat(ef, ef);
        Music r = new Rest(4);
        Music refef = new Concat(r, efef);
        
        Music efefefef = new Together(Arrays.asList(efef, refef));
        
        // Tests toString
        assertEquals("expected correct toString", 
                "Together([" +
                        "Concat(Concat(Note(1.5,E),Note(0.5,F)),Concat(Note(1.5,E),Note(0.5,F))), " + 
                        "Concat(Rest(4.0),Concat(Concat(Note(1.5,E),Note(0.5,F)),Concat(Note(1.5,E),Note(0.5,F))))" + 
                        "])",
                efefefef.toString());
        
        SequencePlayer player = new SequencePlayer(DEFAULT_BPM, 2);
        
        // Tests queue: atBeat = 0
        efefefef.queue(player, 0);
        String[] expectedLines = new String[] {
                "Event: NOTE_ON  Pitch: 64  Tick: 0",
                "Event: NOTE_OFF Pitch: 64  Tick: 3",
                "Event: NOTE_ON  Pitch: 65  Tick: 3",
                "Event: NOTE_OFF Pitch: 65  Tick: 4",
                "Event: NOTE_ON  Pitch: 64  Tick: 4",
                "Event: NOTE_OFF Pitch: 64  Tick: 7",
                "Event: NOTE_ON  Pitch: 65  Tick: 7",
                "Event: NOTE_OFF Pitch: 65  Tick: 8",
                "Event: NOTE_ON  Pitch: 64  Tick: 8",
                "Event: NOTE_OFF Pitch: 64  Tick: 11",
                "Event: NOTE_ON  Pitch: 65  Tick: 11",
                "Event: NOTE_OFF Pitch: 65  Tick: 12",
                "Event: NOTE_ON  Pitch: 64  Tick: 12",
                "Event: NOTE_OFF Pitch: 64  Tick: 15",
                "Event: NOTE_ON  Pitch: 65  Tick: 15",
                "Event: NOTE_OFF Pitch: 65  Tick: 16",
                "Meta event: END_OF_TRACK Tick: 16"
        };
        comparePlayerLines(player, expectedLines);
    }
}
