import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Anagram {
    private String base;

    public Anagram(String word) {
        this.base = word.toLowerCase();
    }

    private String sorted(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }


    private Boolean isAnagram(String w) {
        String word = w.toLowerCase();
        return !word.equals(this.base) && sorted(word).equals(sorted(this.base));
    }

    public List<String> match(List<String> words) {
        return words.stream()
                .filter(this::isAnagram)
                .collect(Collectors.toList());
    }
}
