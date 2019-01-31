package abc.player;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import abc.piece.ParseException;
import abc.piece.Piece;

/**
 * Main entry point of your application.
 */
public class Main {

    /**
     * Plays the input file using Java MIDI API and displays
     * header information to the standard output stream.
     * 
     * (Your code should not exit the application abnormally using
     * System.exit().)
     * 
     * Input file should follow the spec at http://web.mit.edu/6.005/www/sp16/projects/abcplayer/spec/
     * 
     * Nested repeats are not allowed. No colons allowed in comments. Tuplets must have size <= 4.  
     * 
     * @param file the name of input abc file
     * @throws IOException if the file cannot be accessed
     * @throws ParseException if the file cannot be parsed
     */
    public static void play(String file) throws IOException {
        StringBuilder contents = new StringBuilder();
        for(String line : Files.readAllLines(Paths.get(file))) {
            contents.append(line);
            contents.append('\n');
        }
        
        Piece piece = new Piece(contents.toString());
        
        System.out.println(piece.getHeader().toString());
        
        try {
            piece.play();
        } catch (InvalidMidiDataException e) {
            System.err.println("Unknown error in MIDI player");
        } catch (MidiUnavailableException e) {
            System.err.println("MIDI player could not be opened");
        }
    }

    /**
     * Main method which checks validity of input and plays the input file
     * @param args the filename to parse and play
     * @throws IOException if the file cannot be accessed
     * @throws ParseException if the file cannot be parsed
     */
    public static void main(String[] args) throws IOException {
        // Check that args.length == 1, and args[0] is a valid filename
        try{
            if(args.length != 1){
                throw new IllegalArgumentException("Incorrect number of arguments");
            }
            File file = new File(args[0]);
            if(!file.exists()){
                throw new IllegalArgumentException("File does not exist");
            }
        }
        catch(IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
            System.err.println("Usage: Main [filename]");
            return;
        }
        
        play(args[0]);
    }
}
