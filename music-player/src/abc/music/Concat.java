package abc.music;

import java.util.Objects;

import abc.sound.SequencePlayer;

/**
 * Represents two pieces of music, one played the other.
 */
public class Concat implements Music {

    // Abstraction function:
    //   represents m1 followed immediately by m2
    // Rep invariant:
    //   m1, m2 are not null
    // Safety from rep exposure:
    //   fields are private final, and immutable types
    //   returned types are immutable
    
    private final Music m1;
    private final Music m2;
    
    private void checkRep() {
        assert m1 != null : "m1 must not be null";
        assert m2 != null : "m2 must not be null";
    }
    
    /**
     * Constructs this concatenation of music m1 followed immediately by music m2.
     * @param m1 first music
     * @param m2 second music
     */
    public Concat(Music m1, Music m2) {
        this.m1 = m1;
        this.m2 = m2;
        checkRep();
    }

    @Override
    public double duration() {
        checkRep();
        return m1.duration() + m2.duration();
    }

    @Override
    public void queue(SequencePlayer player, double atBeat) {
        m1.queue(player, atBeat);
        m2.queue(player, atBeat + m1.duration());
        checkRep();
    }
    
    @Override
    public boolean equals(Object that) {
        if(!(that instanceof Concat)) return false;
        Concat thatConcat = (Concat) that;
        checkRep();
        return thatConcat.m1.equals(m1) && thatConcat.m2.equals(m2);
    }
    
    @Override
    public int hashCode() {
        checkRep();
        return Objects.hash(m1, m2);
    }
    
    @Override
    public String toString() {
        checkRep();
        return "Concat(" + m1 + "," + m2 + ")";
    }

}
