package abc.piece;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import abc.header.Header;
import abc.header.ListenerMakeHeader;
import abc.music.ListenerMakeMusic;
import abc.music.Music;
import abc.parser.HeaderLexer;
import abc.parser.HeaderParser;
import abc.parser.MusicLexer;
import abc.parser.MusicParser;
import abc.sound.SequencePlayer;

/**
 * A Piece represents a musical score with header and music body described in abc to spec found here: 
 *      http://web.mit.edu/6.005/www/sp16/projects/abcplayer/spec/
 */
public class Piece {
    
    // Abstration Function: 
    //   represents a piece consisting of the header and music
    //   ticksPerBeat represents the number of ticks per beat at which the music can be played
    //      in a sequence player
    // Invariant:
    //   fields are not null
    //   ticksPerBeat > 0
    // Rep Exposure:
    //   all fields are private final
    //   all returned types are immutable
    
    private final Header header;
    private final Music music;
    private final int ticksPerBeat;
    
    private void checkRep() {
        assert header != null;
        assert music != null;
        assert ticksPerBeat > 0;
    }
    
    /**
     * Creates a piece by parsing the given abc text.
     * @param fileContents string in abc format containing the header followed by the body of
     * this piece, wherein newlines are separated by "\n"
     * @throws ParseException if the input cannot be parsed
     */
    public Piece(String fileContents) {
        try {
            int splitIndex = findHeaderSplitIndex(fileContents);
            
            String headerString = fileContents.substring(0, splitIndex);
            HeaderParser headerParser = makeHeaderParser(headerString);
            ListenerMakeHeader headerListener = new ListenerMakeHeader();
            new ParseTreeWalker().walk(headerListener, headerParser.root());
            header = headerListener.getHeader();
            
            String musicString = fileContents.substring(splitIndex);
            MusicParser musicParser = makeMusicParser(musicString);
            ListenerMakeMusic musicListener = new ListenerMakeMusic(header);
            new ParseTreeWalker().walk(musicListener, musicParser.root());
            music = musicListener.getMusic();
            ticksPerBeat = musicListener.getTicksPerBeat();
        } catch(ParseException pe) {
            throw pe;
        } catch(RuntimeException re) {
            throw new ParseException(re);
        }
        
        checkRep();
    }
    
    /**
     * @param header string containing the header of an abc file
     * @return a header parser for the string, which reports errors as exceptions
     */
    private static HeaderParser makeHeaderParser(String header) {
        CharStream stream = new ANTLRInputStream(header);
        
        HeaderLexer lexer = new HeaderLexer(stream);
        lexer.reportErrorsAsExceptions();
        
        TokenStream tokens = new CommonTokenStream(lexer);
        
        HeaderParser parser = new HeaderParser(tokens);
        parser.reportErrorsAsExceptions();
        
        return parser;
    }
    
    /**
     * @param music string containing the body of an abc file
     * @return a music parser for the string, which reports errors as exceptions
     */
    private static MusicParser makeMusicParser(String music) {
        CharStream stream = new ANTLRInputStream(music);
        
        MusicLexer lexer = new MusicLexer(stream);
        lexer.reportErrorsAsExceptions();
        
        TokenStream tokens = new CommonTokenStream(lexer);
        
        MusicParser parser = new MusicParser(tokens);
        parser.reportErrorsAsExceptions();
        
        return parser;
    }
    

    /**
     * Attempt to find an index at which to try splitting contents into a header and music body.
     * Note that if contents is a properly formatted abc file, only one such index exists.
     * @param contents a string wherein newlines are delimited by "\n"
     * @return the first index i such that the last line of contents.substring(0, i) starts with
     * "K:", this line is preceded by "\n", and this line terminates with "\n"
     * @throws ParseException if no such index exists
     */
    private static int findHeaderSplitIndex(String contents){
        int indexOfKeyField = contents.indexOf("\nK:");
        if(indexOfKeyField < 0) {
            throw new ParseException("Key field not found");
        }
        int indexOfNewlineAfterKey = contents.indexOf("\n", indexOfKeyField + 1);
        if(indexOfNewlineAfterKey < 0) {
            throw new ParseException("Newline after key field not found");
        }
        return indexOfNewlineAfterKey + 1;
    }
    
    /**
     * @return the music passed in as input
     */
    public Music getMusic(){
        return music;
    }
    
    /**
     * @return the header passed in as input
     */
    public Header getHeader(){
        return header;
    }
    
    /**
     * Play the music in this piece.
     * @throws InvalidMidiDataException
     * @throws MidiUnavailableException if a MIDI sequence player cannot be opened 
     */
    public void play() throws InvalidMidiDataException, MidiUnavailableException {
        SequencePlayer sp = new SequencePlayer(header.getTempoBPM(), ticksPerBeat);
        music.queue(sp, 0);
        sp.play();
    }
    
    
    @Override
    public String toString(){
        return header.toString() + "\n" + music.toString();
    }
    
    @Override
    public int hashCode(){
        return header.hashCode() + music.hashCode();
    }
    @Override
    public boolean equals(Object thatObj){
        if (! (thatObj instanceof Piece)){
            return false;
        }
        Piece thatPiece = (Piece) thatObj;
        return thatPiece.getHeader().equals(header) && thatPiece.getMusic().equals(music);
    }

}
