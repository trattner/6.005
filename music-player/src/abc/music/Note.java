package abc.music;

import java.util.Objects;

import abc.sound.Pitch;
import abc.sound.SequencePlayer;

/**
 * Represents a single note of music.
 */
public class Note implements Music {
    
    // Abstraction function:
    //   represents the note corresponding to the pitch, played
    //   for the specified duration in beats
    // Rep invariant:
    //   duration is positive and finite
    //   pitch is not null
    // Safety from rep exposure:
    //   fields are private final, and immutable types
    //   returned types are immutable
    
    private final double duration;
    private final Pitch pitch;
    
    private void checkRep() {
        assert Double.isFinite(duration) : "duration must be finite";
        assert duration > 0 : "duration must be positive";
        assert pitch != null : "pitch must not be null";
    }
    
    /**
     * Construct a note.
     * @param duration duration in beats of the note;
     * required be positive and finite
     * @param pitch pitch at which to play the note
     */
    public Note(double duration, Pitch pitch) {
        this.duration = duration;
        this.pitch = pitch;
        checkRep();
    }

    @Override
    public double duration() {
        checkRep();
        return duration;
    }

    @Override
    public void queue(SequencePlayer player, double atBeat) {
        player.addNote(pitch.toMidiNote(), atBeat, duration);
        checkRep();
    }
    
    @Override
    public boolean equals(Object that) {
        if(!(that instanceof Note)) return false;
        Note thatNote = (Note) that;
        checkRep();
        return thatNote.duration == duration && thatNote.pitch.equals(pitch);
    }
    
    @Override
    public int hashCode() {
        checkRep();
        return Objects.hash(duration, pitch);
    }
    
    @Override
    public String toString() {
        checkRep();
        return "Note(" + duration + "," + pitch + ")";
    }

}
