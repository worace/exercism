import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;

public class Pangrams {
    private static HashSet<Character> alphabet = new HashSet<>();

    static {
        for (Character c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            alphabet.add(c);
        }
    }

    public static Boolean isPangram(String phrase) {
        HashSet<Character> letters = new HashSet<>();
        for (Character c : phrase.toLowerCase().replaceAll("[^a-z]", "").toCharArray()) {
            letters.add(c);
        }
        return letters.equals(alphabet);
    }
}
