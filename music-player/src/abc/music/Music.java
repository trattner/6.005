package abc.music;

import abc.sound.SequencePlayer;

/**
 * An immutable data-type representing sequences of notes, rests, and chords.
 */
public interface Music {
    // Datatype definition:
    // Music = Note(duration:double, pitch:Pitch)
    //        + Rest(duration:double)
    //        + Concat(m1:Music, m2:Music)
    //        + Together(lines:List<Music>)
    
    // empty music is represented by rest of 0 duration
    
    /**
     * @return the duration of this section of music, in beats. Note that
     * a piece of music is only guaranteed to end after this many beats if
     * it contains a single line. Formally, if another section of music is
     * to be played immediately after this one, this returns the number of
     * beats after the start of this section when the next section may be
     * started.
     */
    double duration();
    
    /**
     * Queue this music in the given sequence player.
     * @param player player to play on
     * @param atBeat beat at which to start playing;
     * must be nonnegative and finite
     */
    void queue(SequencePlayer player, double atBeat);
    
    /**
     * @return a string representation of this Music such that whenever
     * <code>this.equals(that)</code>,
     * it holds that
     * <code>this.toString().equals(that.toString())</code>.
     * Specifically, Music subtypes return the name of the subtype,
     * followed by the string representations of the arguments passed
     * to the constructor of that subtype, in the order they appear in
     * the constructor. These arguments are enclosed with parentheses,
     * and are separated by commas.
     */
    @Override String toString();
    
    /**
     * Compare this Music with another object for equality.
     * @param that object to compare to
     * @return true if and only if this and that are structurally equal
     * Music instances
     */
    @Override boolean equals(Object that);
}
