package abc.piece;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

import abc.header.Header;

/**
 * @category no_didit
 */
public class PieceTest {
    
    /*
     * Testing strategy:
     * 
     * ---findHeaderSplitIndex partitions
     *      
     * ---parse
     *      optional fields missing, present
     *      Common time C|
     *      default note length <1/4,1/4,>1/4
     *      repeats, first second ending
     *      
     * ---play
     *      test by ear
     *      
     * ---toString
     *      equal for same music
     *      equals header.toString() + music.toString()
     */

    @Test
    public void testHeaderSplitIndex() {
        String beethoven = "X:122\nT:Bagatelle No.25 in A, WoO.59\nC:Ludwig van Beethoven%comment comment K\nV:1\nV:2\nM:3/8\nL:1/16\nQ:1/8=140\nK:Am\n A B C D | D F G G |\n%comment K this is a false key \n";
        Piece furElise = new Piece(beethoven);
        
        Header furHead = furElise.getHeader();
        String[] headerSplit = furHead.toString().split("\n");
        assertEquals("expected K:Am", headerSplit[headerSplit.length-1], "K:Am");
    }
    
    @Test
    public void testParseEquals() throws InvalidMidiDataException, MidiUnavailableException, IOException{
        List<String> inputStrings = Files.readAllLines(Paths.get("sample_abc/piece2.abc"), Charset.defaultCharset());
        String input = "";
        for (String s: inputStrings) {
            input += s + "\n";
        }

        Piece p = new Piece(input);
        Piece p2 = new Piece(input);
                
        assertEquals("expected piece to equal self", p, p2);
        
        //p.play();
        //try{Thread.sleep(8000);}catch(Exception e){}
    }
    
    @Test
    public void testParseCommonTime(){
        
    }
    
    @Test
    public void testChordsOptionals() throws IOException, MidiUnavailableException, InvalidMidiDataException{
        List<String> inputStrings = Files.readAllLines(Paths.get("sample_abc/sample3.abc"), Charset.defaultCharset());
        String input = "";
        for (String s: inputStrings) {
            input += s + "\n";
        }

        Piece p = new Piece(input);
        
        p.play();
        try{Thread.sleep(8000);}catch(Exception e){}
    }
    
    @Test
    public void testPlay() throws IOException, MidiUnavailableException, InvalidMidiDataException{
        List<String> inputStrings = Files.readAllLines(Paths.get("sample_abc/little_night_music.abc"), Charset.defaultCharset());
        String input = "";
        for (String s: inputStrings) {
            input += s + "\n";
        }

        Piece p = new Piece(input);
        
        p.play();
        try{Thread.sleep(1200);}catch(Exception e){}
        
    }
    
    @Test
    public void testRepeats() throws IOException, InvalidMidiDataException, MidiUnavailableException{
        List<String> inputStrings = Files.readAllLines(Paths.get("sample_abc/fur_elise.abc"), Charset.defaultCharset());
        String input = "";
        for (String s: inputStrings) {
            input += s + "\n";
        }
        Piece p = new Piece(input);
        
        p.play();
        try{Thread.sleep(15000);} catch (Exception e){}
        
    }
    
    @Test
    public void testVoices() throws IOException, InvalidMidiDataException, MidiUnavailableException{
        List<String> inputStrings = Files.readAllLines(Paths.get("sample_abc/invention.abc"), Charset.defaultCharset());
        String input = "";
        for (String s: inputStrings) {
            input += s + "\n";
        }
        
        Piece p = new Piece(input);
        p.play();
        try{Thread.sleep(8000);}catch(Exception e){}
    }
}
