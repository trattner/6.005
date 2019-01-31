package abc.sound;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

import abc.player.Main;

/**
 * @category no_didit
 */
public class SequencePlayerTest {
    
    @Test
    public void testPiece1() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException, IOException {
        //piece 1: | C C C3/4 D/4 E | E3/4 D/4 E3/4 F/4 G2 | 
        //         (3ccc (3GGG (3EEE (3CCC | G3/4 F/4 E3/4 D/4 C2 |]
        
        String piece1Path = "sample_abc/piece1.abc";
            
        Main.play(piece1Path);
        
        Thread.sleep(8000);
        
        //compare to SequencePlayer
        SequencePlayer sp;      
        
        sp = new SequencePlayer(140,12);
        int qn = 12; //quarterNote
        int tp = 4; //triplet
        int hn = 24; //half note
        int st = 3; //sixteenth note
        int de = 9; //dotted eighth
        
        int c = new Pitch('C').toMidiNote();
        int d = new Pitch('D').toMidiNote();
        int e = new Pitch('E').toMidiNote();
        int f = new Pitch('F').toMidiNote();
        int g = new Pitch('G').toMidiNote();
        int cOct = new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote();
        
        int[] notes = {c,c,c,d,e,e,d,e,f,g,cOct,cOct,cOct,g,g,g,e,e,e,c,c,c,g,f,e,d,c};
        int[] durations = {qn,qn,de,st,qn,de,st,de,st,hn,tp,tp,tp,tp,tp,tp,tp,tp,tp,tp,tp,tp,de,st,de,st,hn};
        
        assertEquals("expected notes and duration equal", notes.length, durations.length);
        
        int currentTick = 0;
        
        for (int i = 0; i<notes.length; i++){
            sp.addNote(notes[i], currentTick, durations[i]);
            currentTick += durations[i];
        }
        
        sp.play();
        
        Thread.sleep(8000);
        
        String melody = sp.toString();
        System.out.println(melody);
        
    }
    
    @Test
    public void testPiece2() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException, IOException {
      //piece 2: | [^Fe]/ [Fe]/ z/ [Fe]/ z/2 [Fc]/2 [Fe] | 
      //            [GBg] z G z | c3/ G/ z E | E/2 A B _B/ A | 
      //            (3Geg a f/ g/ | z/ e c/ d/ B3/4 z3/4 |]
        
        String piece2Path = "sample_abc/piece2.abc";
            
        Main.play(piece2Path);
        
        Thread.sleep(8000);
        
        //compare to SequencePlayer
        SequencePlayer sp;      
        
        sp = new SequencePlayer(200,12);
        int qn = 12; //quarterNote
        int tp = 8; //triplet
        int en = 6; //eighth note
        int de = 9; //dotted eighth
        int dq= 18; //dotted quarter
        
        int e = new Pitch('E').toMidiNote();
        int f = new Pitch('F').toMidiNote();
        int fs = new Pitch('F').transpose(1).toMidiNote();
        int g = new Pitch('G').toMidiNote();
        int a = new Pitch('A').toMidiNote();
        int b = new Pitch('B').toMidiNote();
        int bf = new Pitch('B').transpose(-1).toMidiNote();
        int cO = new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote();
        int dO = new Pitch('D').transpose(Pitch.OCTAVE).toMidiNote();
        int eO = new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote();
        int fO = new Pitch('F').transpose(Pitch.OCTAVE).toMidiNote();
        int gO = new Pitch('G').transpose(Pitch.OCTAVE).toMidiNote();
        int aO = new Pitch('A').transpose(Pitch.OCTAVE).toMidiNote();
        int r = -1; //rest
                    
        int[] notes =     {fs,eO,fs,eO,r,f,eO,r,f,cO,f,eO,
                           g,b,gO,r,g,r,
                           cO,g,r,e,
                           e,a,b,bf,a,
                           g,eO,gO,aO, fO, gO,
                           r, eO, cO, dO, b, r
                          };
        int[] durations = {en,en,en,en,en,en,en,en,en,en,qn,qn,
                           qn,qn,qn,qn,qn,qn,
                           dq, en, qn, qn,
                           en, qn, qn, en, qn,
                           tp,tp,tp,qn,en,qn,
                           en,qn,en,en,de,de
                          };
        int[] chords =    {2,1,2,1,1,2,1,1,2,1,2,1,
                           2,2,1,1,1,1,
                           1,1,1,1,
                           1,1,1,1,1,
                           1,1,1,1,1,1,
                           1,1,1,1,1,1
                          };
        
        assertEquals("expected notes and duration equal", notes.length, durations.length);
        assertEquals("expected notes and chords equal", notes.length, chords.length);
        
        int currentTick = 0;
        
        //insert notes, chords, and rests
        for (int i = 0; i<notes.length; i++){
            if (notes[i] == r){
                currentTick += durations[i];
            } else {
                sp.addNote(notes[i], currentTick, durations[i]);
                if (chords[i]==1) currentTick += durations[i];
                //else chords[i]==2 and currentTick=currentTick                             
            }
        }
        
        sp.play();
        
        Thread.sleep(8000);
        
        String melody = sp.toString();
        System.out.println(melody);
    }
    

}
