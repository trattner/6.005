package abc.header;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;

import abc.sound.Pitch;

/**
 * Tests for Header
 */
public class HeaderTest {

    /*
     * Testing Strategy:
     * 
     * Header partitions, used to test all methods:
     *   header contains all, no optionals, meter but not length
     *   key signature has sharp, flat, natural
     *   
     *   
     * Additional partitions for specific methods:
     *   equals():
     *     that is equal, same fields but not structurally equal, not equal
     * 
     * Other strategies:
     *   verify that toString and hashCode are equal for equal Header
     */

    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testHeaderAllFields() {
        //with sharp key signature
        
        String index = "134";
        String title = "TestTitle All Fields";
        String key = "F#";
        Optional<String> composer = Optional.of("Test Composer");
        Optional<String> meter = Optional.of("6/8");
        Optional<String> length = Optional.of("1/8");
        Optional<String> tempo = Optional.of("3/8=96");
        Set<String> voices = new HashSet<>(Arrays.asList("1", "2", "3", "4"));
        Header h = new Header(index, title, key, composer, meter, length, tempo, voices);
        
        assertEquals("expected index 134", 134, h.getIndex());
        assertEquals("expected title TestTitle", title, h.getTitle());
        assertEquals("expected key F#", key, h.getKey());
        assertEquals("expected composer Test Composer", composer.get(), h.getComposer());
        assertEquals("expected meter 6/8", 6, h.getMeterNumerator());
        assertEquals("expected meter 6/8", 8, h.getMeterDenominator());
        assertEquals("expected length 1/8", 1, h.getLengthNumerator());
        assertEquals("expected length 1/8", 8, h.getLengthDenominator());
        assertEquals("expected tempo 3/8=96", 96, h.getTempoBPM());
        assertEquals("expected tempo 3/8=96", 3, h.getBeatNumerator());
        assertEquals("expected tempo 3/8=96", 8, h.getBeatDenominator());
        assertEquals("expected four voices", voices, h.getVoices());
        
        assertTrue("expected keyset for diatonic scale degrees for F# major",
                h.getKeyMap().keySet().containsAll(Arrays.asList("A","B","C","D","E","G","F")));
        assertEquals("expected F#", new Pitch('F').transpose(1), h.getKeyMap().get("F"));
        assertEquals("expected C#", new Pitch('C').transpose(1), h.getKeyMap().get("C"));
        assertEquals("expected G#", new Pitch('G').transpose(1), h.getKeyMap().get("G"));
        assertEquals("expected D#", new Pitch('D').transpose(1), h.getKeyMap().get("D"));
        assertEquals("expected A#", new Pitch('A').transpose(1), h.getKeyMap().get("A"));
        assertEquals("expected E#", new Pitch('E').transpose(1), h.getKeyMap().get("E"));
        assertEquals("expected B", new Pitch('B'), h.getKeyMap().get("B"));
        
        assertEquals("expected note length 1/3 of a beat", 1.0 / 3.0, h.getNoteLength(), 0.0001);
    }
    
    @Test
    public void testHeaderNoOptionals() {
        // with natural key signature minor
        
        String index = "0";
        String title = "TestTitle No Fields";
        String key = "Am";
        Optional<String> composer = Optional.empty();
        Optional<String> meter = Optional.empty();
        Optional<String> length = Optional.empty();
        Optional<String> tempo = Optional.empty();
        Set<String> voices = Collections.emptySet();
        Header h = new Header(index, title, key, composer, meter, length, tempo, voices);
        
        assertEquals("expected index 0", 0, h.getIndex());
        assertEquals("expected title TestTitle", title, h.getTitle());
        assertEquals("expected key Am", key, h.getKey());
        assertEquals("expected composer Unknown", "Unknown", h.getComposer());
        assertEquals("expected meter 4/4", 4, h.getMeterNumerator());
        assertEquals("expected meter 4/4", 4, h.getMeterDenominator());
        assertEquals("expected length 1/8", 1, h.getLengthNumerator());
        assertEquals("expected length 1/8", 8, h.getLengthDenominator());
        assertEquals("expected tempo 1/8=100", 100, h.getTempoBPM());
        assertEquals("expected tempo 1/8=100", 1, h.getBeatNumerator());
        assertEquals("expected tempo 1/8=100", 8, h.getBeatDenominator());
        assertEquals("expected no voices", voices, h.getVoices());
        
        assertTrue("expected keyset for diatonic scale degrees for A minor",
                h.getKeyMap().keySet().containsAll(Arrays.asList("A","B","C","D","E","G","F")));
        assertEquals("expected F", new Pitch('F'), h.getKeyMap().get("F"));
        assertEquals("expected C", new Pitch('C'), h.getKeyMap().get("C"));
        assertEquals("expected G", new Pitch('G'), h.getKeyMap().get("G"));
        assertEquals("expected D", new Pitch('D'), h.getKeyMap().get("D"));
        assertEquals("expected A", new Pitch('A'), h.getKeyMap().get("A"));
        assertEquals("expected E", new Pitch('E'), h.getKeyMap().get("E"));
        assertEquals("expected B", new Pitch('B'), h.getKeyMap().get("B"));
        
        assertEquals("expected note length 1 beat", 1.0, h.getNoteLength(), 0.0001);
    }
    
    @Test
    public void testHeaderMeterNoLength() {
        // with flat key signature
        
        String index = "0";
        String title = "TestTitle Meter No Length Fields";
        String key = "Eb";
        Optional<String> composer = Optional.empty();
        Optional<String> meter = Optional.of("2/4");
        Optional<String> length = Optional.empty();
        Optional<String> tempo = Optional.empty();
        Set<String> voices = Collections.emptySet();
        Header h = new Header(index, title, key, composer, meter, length, tempo, voices);
        
        assertEquals("expected index 0", 0, h.getIndex());
        assertEquals("expected title TestTitle", title, h.getTitle());
        assertEquals("expected key Eb", key, h.getKey());
        assertEquals("expected composer Unknown", "Unknown", h.getComposer());
        assertEquals("expected meter 2/4", 2, h.getMeterNumerator());
        assertEquals("expected meter 2/4", 4, h.getMeterDenominator());
        assertEquals("expected length 1/16", 1, h.getLengthNumerator());
        assertEquals("expected length 1/16", 16, h.getLengthDenominator());
        assertEquals("expected tempo 1/16=100", 100, h.getTempoBPM());
        assertEquals("expected tempo 1/16=100", 1, h.getBeatNumerator());
        assertEquals("expected tempo 1/16=100", 16, h.getBeatDenominator());
        assertEquals("expected no voices", voices, h.getVoices());
        
        assertTrue("expected keyset for diatonic scale degrees for Eb major",
                h.getKeyMap().keySet().containsAll(Arrays.asList("A","B","C","D","E","G","F")));
        assertEquals("expected F", new Pitch('F'), h.getKeyMap().get("F"));
        assertEquals("expected C", new Pitch('C'), h.getKeyMap().get("C"));
        assertEquals("expected G", new Pitch('G'), h.getKeyMap().get("G"));
        assertEquals("expected D", new Pitch('D'), h.getKeyMap().get("D"));
        assertEquals("expected Ab", new Pitch('A').transpose(-1), h.getKeyMap().get("A"));
        assertEquals("expected Eb", new Pitch('E').transpose(-1), h.getKeyMap().get("E"));
        assertEquals("expected Bb", new Pitch('B').transpose(-1), h.getKeyMap().get("B"));
        
        assertEquals("expected note length 1 beat", 1.0, h.getNoteLength(), 0.0001);
    }
    
    @Test
    public void testEqualHeader() {
        // default
        
        String index = "0";
        String title = "TestTitle Meter No Length Fields";
        String key = "Ebm";
        Optional<String> composer1 = Optional.empty();
        Optional<String> composer2 = Optional.of("Unknown");
        Optional<String> meter = Optional.of("2/4");
        Optional<String> length1 = Optional.empty();
        Optional<String> length2 = Optional.of("1/16");
        Optional<String> tempo1 = Optional.empty();
        Optional<String> tempo2 = Optional.of("1/16=100");
        Set<String> voices = Collections.emptySet();
        Header h1 = new Header(index, title, key, composer1, meter, length1, tempo1, voices);
        Header h2 = new Header(index, title, key, composer2, meter, length2, tempo2, voices);
        
        assertEquals("expected equal headers", h1, h2);
        assertEquals("expected equal hashCode", h1.hashCode(), h2.hashCode());
        assertEquals("expected equal toString", h1.toString(), h2.toString());
    }

}
