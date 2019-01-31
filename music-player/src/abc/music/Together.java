package abc.music;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import abc.sound.SequencePlayer;

/**
 * Represents multiple lines of music played simultaneously.
 */
public class Together implements Music {

    // Abstraction function:
    //   represents the music in lines played simultaneously
    // Rep invariant:
    //   lines.size() > 0
    //   all music in lines is not null
    // Safety from rep exposure:
    //   fields are private final, and immutable types
    //   returned types are immutable
    //   lines is copied defensively and stored in an unmodifiable wrapper
    
    private final List<Music> lines;
    
    private void checkRep() {
        assert lines.size() > 0 : "lines must have positive length";
        for(Music line : lines){
            assert line != null : "lines must not be null";
        }
    }
    
    /**
     * Construct this together of one or more lines playing simultaneously.
     * @param lines nonempty list of musical lines, copied by this constructor
     */
    public Together(List<Music> lines) {
        List<Music> linesCopy = new ArrayList<Music>(lines);
        this.lines = Collections.unmodifiableList(linesCopy);
        checkRep();
    }

    @Override
    public double duration() {
        checkRep();
        return lines.get(0).duration();
    }

    @Override
    public void queue(SequencePlayer player, double atBeat) {
        for(Music music : lines) {
            music.queue(player, atBeat);
        }
        checkRep();
    }
    
    @Override
    public boolean equals(Object that) {
        if(!(that instanceof Together)) return false;
        Together thatTogether = (Together) that;
        checkRep();
        return thatTogether.lines.equals(lines);
    }
    
    @Override
    public int hashCode() {
        checkRep();
        return lines.hashCode();
    }
    
    @Override
    public String toString() {
        checkRep();
        return "Together(" + lines.toString() + ")";
    }

}
