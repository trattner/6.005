package abc.music;

import abc.sound.SequencePlayer;

/**
 * Represents a rest, i.e. no music for some duration.
 */
public class Rest implements Music {

    // Abstraction function:
    //   represents a rest lasting for duration beats
    // Rep invariant:
    //   duration is nonnegative and finite
    // Safety from rep exposure:
    //   fields are private final, and immutable types
    //   returned types are immutable
    
    private final double duration;
    
    private void checkRep() {
        assert Double.isFinite(duration) : "duration must be finite";
        assert duration >= 0 : "duration must be nonnegative";
    }
    
    /**
     * Construct this rest of specified duration. 
     * @param duration duration in beats of the rest;
     * required be nonnegative and finite
     */
    public Rest(double duration) {
        this.duration = duration;
        checkRep();
    }

    @Override
    public double duration() {
        checkRep();
        return duration;
    }

    @Override
    public void queue(SequencePlayer player, double atBeat) {
        checkRep();
        return;
    }
    
    @Override
    public boolean equals(Object that) {
        if(!(that instanceof Rest)) return false;
        Rest thatRest = (Rest) that;
        checkRep();
        return thatRest.duration == duration;
    }
    
    @Override
    public int hashCode() {
        checkRep();
        return Double.hashCode(duration);
    }
    
    @Override
    public String toString() {
        checkRep();
        return "Rest(" + duration + ")";
    }

}
