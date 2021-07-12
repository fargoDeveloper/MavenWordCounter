import java.util.HashMap;
import java.util.List;

/**
 * This class count the number of duplicate word in the input file
 */
public class DuplicateCounter {
    public HashMap countWords(List<String> words, HashMap<String, Integer> wordCountMap) {
        for (String word : words) {
            if (wordCountMap.keySet().contains(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }
        return wordCountMap;
    }
}

