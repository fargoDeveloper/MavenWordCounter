import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class extract words from the input file
 */
public class LineConverter {
    List<String> wordsList = new ArrayList<>();
    List<String> convertedList;

    public List<String> extractWords(String linesFromFile) {
        String line = linesFromFile;
        line = line.trim();
        line = line.toLowerCase();

        // remove extra characters in to line
        line = line.replaceAll("[//\\()?\\–\\—:_!@~`#№$%^&*=\'\"\t\b\r.\\+,;\n{}<>]+", "");
        line = line.replaceAll("[\\xC2\\xA0]+", " ");
        convertedList = Arrays.asList(line.split(" "));

        for (int i = 0; i < convertedList.size(); i++) {
            if (!convertedList.get(i).equals("")) {
                wordsList.add(convertedList.get(i));
            }
        }
        return wordsList;
    }
}
