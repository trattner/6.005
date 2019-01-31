package abc.keys;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import abc.sound.Pitch;

/**
 * A class with one static method to return an unmodifiable key map from notes to pitches.
 */
public class Keys {
      
    /**
     * 
     * @param key the desired key in uppercase, e.g. F#, Bb
     * @param minorTrue boolean representing minor flag to accompany key if minor desired, e.g. F#m-->true, Bb-->false
     * @return
     */
    public static Map<String, Pitch> getKeyMap(String key, Boolean minorTrue){
        Map<String, String> minorMajorMap = getMinorMajorMap();
        Map<String, Pitch> keyMap;
        
        if (minorTrue) {
            keyMap = makeMajorKeyMap(minorMajorMap.get(key));
        } else {
            keyMap = makeMajorKeyMap(key);
        }
        
        return Collections.unmodifiableMap(keyMap);
        
    }
    
    /**
     * Private method to create major key map based on key signature.
     * @param key uppercase major key, e.g. F#, Eb, C
     * @return Map of strings to pitches for each diatonic uppercase scale note A-G
     */
    private static Map<String,Pitch> makeMajorKeyMap(String key){
        Map<String,Pitch> m = new HashMap<String,Pitch>(); //the major keys up circle of fifths
        m.put("A", new Pitch('A'));
        m.put("B", new Pitch('B'));
        m.put("C", new Pitch('C'));
        m.put("D", new Pitch('D'));
        m.put("E", new Pitch('E'));
        m.put("F", new Pitch('F'));
        m.put("G", new Pitch('G'));
        
        Map<String,Pitch> mb = new HashMap<String,Pitch>(m); //the major keys down circle of fifths
        
        Map<String,Map<String,Pitch>> keys = new HashMap<String,Map<String,Pitch>>();
        
        //up the circle
        keys.put("C", new HashMap<String,Pitch>(m));
        m.replace("F", m.get("F").transpose(1));
        keys.put("G", new HashMap<String,Pitch>(m));
        m.replace("C", m.get("C").transpose(1));
        keys.put("D", new HashMap<String,Pitch>(m));
        m.replace("G", m.get("G").transpose(1));
        keys.put("A", new HashMap<String,Pitch>(m));
        m.replace("D", m.get("D").transpose(1));
        keys.put("E", new HashMap<String,Pitch>(m));
        m.replace("A", m.get("A").transpose(1));
        keys.put("B", new HashMap<String,Pitch>(m));
        m.replace("E", m.get("E").transpose(1));
        keys.put("F#", new HashMap<String,Pitch>(m));
        m.replace("B", m.get("B").transpose(1));
        keys.put("C#", new HashMap<String,Pitch>(m));

        //down the circle
        mb.replace("B", mb.get("B").transpose(-1));
        keys.put("F", new HashMap<String,Pitch>(mb));
        mb.replace("E", mb.get("E").transpose(-1));
        keys.put("Bb", new HashMap<String,Pitch>(mb));
        mb.replace("A", mb.get("A").transpose(-1));
        keys.put("Eb", new HashMap<String,Pitch>(mb));
        mb.replace("D", mb.get("D").transpose(-1));
        keys.put("Ab", new HashMap<String,Pitch>(mb));
        mb.replace("G", mb.get("G").transpose(-1));
        keys.put("Db", new HashMap<String,Pitch>(mb));
        mb.replace("C", mb.get("C").transpose(-1));
        keys.put("Gb", new HashMap<String,Pitch>(mb));
        mb.replace("F", mb.get("F").transpose(-1));
        keys.put("Cb", new HashMap<String,Pitch>(mb));
        
        return keys.get(key);
    }
    /**
     * 
     * @return string mapping from uppercase minor to relative major key 
     */
    private static Map<String,String> getMinorMajorMap(){
        Map<String,String> output = new HashMap<String,String>();
        output.put("A", "C");
        output.put("E", "G");
        output.put("B", "D");
        output.put("F#", "A");
        output.put("C#", "E");
        output.put("G#", "B");
        output.put("D#", "F#");
        output.put("A#", "C#");
        output.put("D", "F");
        output.put("G", "Bb");
        output.put("C", "Eb");
        output.put("F", "Ab");
        output.put("Bb", "Db");
        output.put("Eb", "Gb");
        output.put("Ab", "Cb");
        return output;
    }
}
