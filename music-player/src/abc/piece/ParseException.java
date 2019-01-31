package abc.piece;

/**
 * Indicates an exception in parsing header or music.
 */
public class ParseException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public ParseException(Throwable cause) {
        super(cause);
    }

    public ParseException(String message) {
        super(message);
    }
    
    public ParseException() {
        super();
    }
}