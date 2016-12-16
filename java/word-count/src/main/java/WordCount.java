import java.util.HashMap;

public class WordCount {
    Integer count = 0;

    public HashMap<String, Integer> phrase(String words) {
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        for (String word : words.split(" ")) {
            String preppedWord = word.toLowerCase().replaceAll("\\W", "");
            if (preppedWord.length() > 0) {
                counts.put(preppedWord, counts.getOrDefault(preppedWord, 0) + 1);
            }
        }
        return counts;
    }
}
