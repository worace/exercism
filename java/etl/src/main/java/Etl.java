import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Etl {
    public Map<String, Integer> transform(Map<Integer, List<String>> old) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        for (Map.Entry<Integer, List<String>> entry : old.entrySet()) {
            Integer pointValue = entry.getKey();
            for (String letter : entry.getValue()) {
                result.put(letter.toLowerCase(), pointValue);
            }
        }
        return result;
    }
}
