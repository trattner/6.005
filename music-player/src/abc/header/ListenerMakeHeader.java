package abc.header;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import abc.parser.HeaderBaseListener;
import abc.parser.HeaderParser.*;


public class ListenerMakeHeader extends HeaderBaseListener {

    private String index;
    private String title;
    private String key;
    private Optional<String> composer;
    private Optional<String> meter;
    private Optional<String> length;
    private Optional<String> tempo;
    private final Set<String> voices;
    
    /*
     * Invariant:
     *   index, title, key are null until initialized by exiting respective fields
     */
    
    public ListenerMakeHeader(){
        composer = Optional.empty();
        meter = Optional.empty();
        length = Optional.empty();
        tempo = Optional.empty();
        voices = new HashSet<>();
    }
    
    public Header getHeader(){
        assert index != null;
        assert title != null;
        assert key != null;
        return new Header(index, title, key, composer, meter, length, tempo, voices);
    }

    @Override
    public void exitField_number(Field_numberContext ctx) {
        assert index == null;
        index = ctx.DIGITS().getText();
    }

    @Override
    public void exitField_title(Field_titleContext ctx) {
        assert title == null;
        String titleWithT = ctx.TITLE_TEXT().getText();
        title = trimTextField(titleWithT);
    }

    @Override
    public void exitField_composer(Field_composerContext ctx) {
        String composerWithC = ctx.COMPOSER_TEXT().getText();
        composer = Optional.of(trimTextField(composerWithC));
    }

    @Override
    public void exitField_default_length(Field_default_lengthContext ctx) {
        length = Optional.of(removeWhitespace(ctx.fraction().getText()));
    }
    
    @Override
    public void exitField_key(Field_keyContext ctx) {
        assert key == null;
        key = removeWhitespace(ctx.key().getText());
    }

    @Override
    public void exitField_meter(Field_meterContext ctx) {
        meter = Optional.of(removeWhitespace(ctx.meter().getText()));
    }
    
    @Override
    public void exitField_tempo(Field_tempoContext ctx) {
        tempo = Optional.of(removeWhitespace(ctx.tempo().getText()));
    }

    @Override
    public void exitField_voice(Field_voiceContext ctx) {
        String voiceWithV = ctx.VOICE_TEXT().getText();
        voices.add(trimTextField(voiceWithV));
    }
    
    /**
     * @param text full text of a field before newline
     * @return the field text with field name (e.g. "X:") and trailing/leading
     * whitespace removed
     */
    private static String trimTextField(String text) {
        return text.substring(text.indexOf(':') + 1).trim();
    }
    
    /**
     * @param text text from which to remove whitespace
     * @return text with whitespace removed
     */
    private static String removeWhitespace(String text) {
        return text.replaceAll("\\s","");
    }

}
