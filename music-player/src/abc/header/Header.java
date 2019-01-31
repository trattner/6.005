package abc.header;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import abc.keys.Keys;
import abc.sound.Pitch;

/**
 * An immutable data-type representing meta information about a (namely, the titular) piece of music
 * such as key signature, tempo, etc.
 */
public class Header {
    
    /*
     * Abstraction function:
     *   Represents a musical header as specified at (http://web.mit.edu/6.005/www/sp16/projects/abcplayer/spec/)
     *   Index number given by index
     *   Title given by title
     *   Key given by key
     *   Composer given by composer
     *   Meter given by meterNum / meterDenom
     *   Default note length given by lengthNum / lengthDenom
     *   Tempo given by beatNum / beatDenom = tempoBPM
     *   Voices used given by voices
     * Rep invariant:
     *   All fields are non-null
     *   index >= 0
     *   All other int fields are positive
     * Safety from rep exposure:
     *   All fields are private final
     *   Mutable types passed via constructor are copied defensively
     *   Set and Map instances stored as unmodifiable views
     *   All returned values of observers are immutable
     */
    
    // Required fields
    private final int index;
    private final String title;
    private final String key;
    
    // Optional fields
    private final String composer;
    private final int meterNum;
    private final int meterDenom;
    private final int lengthNum;
    private final int lengthDenom;
    private final int beatNum;
    private final int beatDenom;
    private final int tempoBPM;
    private final Set<String> voices;
    
    private final Map<String,Pitch> keyMap;
    
    private void checkRep() {
        assert index >= 0;
        
        assert title != null;
        assert key != null;
        assert composer != null;
        assert voices != null;
        assert keyMap != null;
        
        assert meterNum > 0;
        assert meterDenom > 0;
        assert lengthNum > 0;
        assert lengthDenom > 0;
        assert beatNum > 0;
        assert beatDenom > 0;
        assert tempoBPM > 0;
    }
    
    /**
     * Constructs a Header. Input strings must match the formatting for fields as described in
     * http://web.mit.edu/6.005/www/sp16/projects/abcplayer/spec/. These strings must have removed
     * the field name (e.g. "X:"), the newline terminal, and any trailing or leading whitespace.
     * Whitespace in non-text fields must also be removed. All integers used in fields other than
     * the index must be positive.
     * @param index index
     * @param title title
     * @param key key
     * @param composer composer, defaults to "Unknown" if absent
     * @param meter meter, defaults to "4/4" if absent
     * @param length default note length, defaults to "1/16" if meter is less than 3/4, "1/8" otherwise
     * @param tempo tempo, defaults to length + "=100" if absent
     * @param voices set of voices used by this piece, copied defensively
     */
    public Header(
            String index,
            String title,
            String key,
            Optional<String> composer,
            Optional<String> meter,
            Optional<String> length,
            Optional<String> tempo,
            Set<String> voices) {
        // Required fields
        this.index = Integer.parseInt(index);
        this.title = title;
        this.key = key;
        
        // Default to Unknown if absent
        this.composer = composer.orElse("Unknown");
        
        if(meter.isPresent()) {
            String meterText = meter.get();
            if(meterText.equals("C")) {
                // Common time
                this.meterNum = 4;
                this.meterDenom = 4;
            }
            else if(meterText.equals("C|")) {
                // Cut time
                this.meterNum = 2;
                this.meterDenom = 2;
            }
            else {
                // Split the meter fraction
                String[] meterSplit = meterText.split("/");
                assert meterSplit.length == 2;
                this.meterNum = Integer.parseInt(meterSplit[0]);
                this.meterDenom = Integer.parseInt(meterSplit[1]);
            }
        }
        else {
            // Default to common time if absent
            this.meterNum = 4;
            this.meterDenom = 4;
        }
        
        if(length.isPresent()) {
            // Note length fraction
            String[] lengthSplit = length.get().split("/");
            assert lengthSplit.length == 2;
            this.lengthNum = Integer.parseInt(lengthSplit[0]);
            this.lengthDenom = Integer.parseInt(lengthSplit[1]);
        }
        else {
            // Default to note length set by meter if absent
            this.lengthNum = 1;
            if(meterNum * 4 < meterDenom * 3) {
                // i.e. meterNum / meterDenom < 3 / 4, but avoids floating point calculation
                // Default length = 1 / 16
                this.lengthDenom = 16;
            }
            else {
                // Default length = 1 / 8
                this.lengthDenom = 8;
            }
        }
        
        if(tempo.isPresent()) {
            // Split at "/" and "="
            String[] tempoSplit = tempo.get().split("/|=");
            assert tempoSplit.length == 3;
            this.beatNum = Integer.parseInt(tempoSplit[0]);
            this.beatDenom = Integer.parseInt(tempoSplit[1]);
            this.tempoBPM = Integer.parseInt(tempoSplit[2]);
        }
        else {
            // Default to default note length = 100 if absent
            this.beatNum = lengthNum;
            this.beatDenom = lengthDenom;
            this.tempoBPM = 100;
        }
        
        // Copy voices defensively and place in unmodifiable wrapper
        this.voices = Collections.unmodifiableSet(new HashSet<>(voices));
        
        if(key.endsWith("m")) {
            // Minor key
            this.keyMap = Collections.unmodifiableMap(
                    Keys.getKeyMap(key.substring(0, key.length() - 1), true));
        }
        else {
            // Major key
            this.keyMap = Collections.unmodifiableMap(
                    Keys.getKeyMap(key, false));
        }
        
        checkRep();
    }
    
    /**
     * @return index of the musical piece
     */
    public int getIndex(){
        return index;
    }
    
    /**
     * @return title of the musical piece
     */
    public String getTitle(){
        return title;
    }
        
    /**
     * @return the key of the piece
     */
    public String getKey(){
        return key;
    }
    
    /**
     * @return the composer of the piece
     */
    public String getComposer(){
        return composer;
    }
    
    /**
     * @return numerator of meter
     */
    public int getMeterNumerator(){
        return meterNum;
    }
    
    /**
     * @return denominator of meter
     */
    public int getMeterDenominator(){
        return meterDenom;
    }
    
    /**
     * @return numerator of default note length
     */
    public int getLengthNumerator(){
        return lengthNum;
    }
    
    /**
     * @return denominator of default note length
     */
    public int getLengthDenominator(){
        return lengthDenom;
    }
    
    /**
     * @return numerator of beat
     */
    public int getBeatNumerator(){
        return beatNum;
    }
    
    /**
     * @return denominator of beat
     */
    public int getBeatDenominator(){
        return beatDenom;
    }
    
    /**
     * @return tempo of the musical piece in beats per minute
     */
    public int getTempoBPM(){
        return tempoBPM;
    }
    
    /**
     * @return unmodifiable view of voices in header
     */
    public Set<String> getVoices(){
        return voices;
    }
    
    /**
     * @return an unmodifiable view of a map from diatonic scale steps A-G to appropriate Pitches
     */
    public Map<String,Pitch> getKeyMap(){
       return keyMap;
    }
    
    /**
     * @return default note length in beats
     */
    public double getNoteLength(){
        double absoluteLength = (double) lengthNum / lengthDenom;
        double beatLength = (double) beatNum / beatDenom;
        return absoluteLength / beatLength;
    }
    
    /**
     * @return true if and only if thatObject is a structurally equal Header.
     */
    @Override
    public boolean equals(Object thatObject){
        if (!(thatObject instanceof Header)) return false;
        Header thatHeader = (Header) thatObject;
        return thatHeader.getIndex() == getIndex() &&
                thatHeader.getTitle().equals(getTitle()) &&
                thatHeader.getKey().equals(getKey()) &&
                thatHeader.getComposer().equals(getComposer()) &&
                thatHeader.getMeterNumerator() == getMeterNumerator() &&
                thatHeader.getMeterDenominator() == getMeterDenominator() &&
                thatHeader.getLengthNumerator() == getLengthNumerator() &&
                thatHeader.getLengthDenominator() == getLengthDenominator() &&
                thatHeader.getBeatNumerator() == getBeatNumerator() &&
                thatHeader.getBeatDenominator() == getBeatDenominator() &&
                thatHeader.getTempoBPM() == getTempoBPM() &&
                thatHeader.getVoices().equals(getVoices());
    }
    
    @Override
    public int hashCode(){
        return toString().hashCode();
    }
    
    /**
     * @return a string representation of this Header that may be parsed into an equal instance.
     * The returned string includes optional fields that may have been omitted from the constructor.
     */
    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("X:" + index + "\n");
        output.append("T:" + title + "\n");
        output.append("C:" + composer + "\n");
        output.append("M:" + meterNum + "/" + meterDenom + "\n");
        output.append("L:" + lengthNum + "/" + lengthDenom + "\n");
        output.append("Q:" + beatNum + "/" + beatDenom + "=" + tempoBPM + "\n");
        for (String v: voices) output.append("V:" + v + "\n");
        output.append("K:" + getKey());
        return output.toString();
    }
}