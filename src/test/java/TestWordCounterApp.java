import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestWordCounterApp {
    private FromFileReader fromFileReader;
    private LineConverter lineConverter;
    private DuplicateCounter duplicateCounter;
    private HashMap<String, Integer> wordCountMap;

    @Before
    public void initObjects() {
        fromFileReader = new FromFileReader();
        lineConverter = new LineConverter();
        duplicateCounter = new DuplicateCounter();
        wordCountMap = new HashMap<>();
    }

    @Ignore
    public void loadFromFileWhichDoesNotExist() {
        final String FILE_NAME1 = "C://WorkTasks//WordCounter//MavenWordCounter//someFile.txt";
        List<String> linesFromFile = fromFileReader.loadFromFile(FILE_NAME1);
        assertEquals(5, linesFromFile.size());
    }

    @Test
    public void loadFromEmptyFile() {
        final String FILE_NAME2 = "C://WorkTasks//WordCounter//MavenWordCounter//TestEmptyFile.txt";
        List<String> linesFromFile = fromFileReader.loadFromFile(FILE_NAME2);
        assertEquals(0, linesFromFile.size());
    }

    @Test
    public void loadFromFile() {
        final String FILE_NAME3 = "C://WorkTasks//WordCounter//MavenWordCounter//TestFile.txt";
        List<String> linesFromFile = fromFileReader.loadFromFile(FILE_NAME3);
        assertEquals(6, linesFromFile.size());
    }

    @Test
    public void getConvertLine() {
        List<String> linesFromFile = Arrays.asList("Жили, ! себе -дед да; баба. Дед говорит бабе");
        List<String> wordsList = lineConverter.extractWords(linesFromFile.get(0));
        assertEquals(8, wordsList.size());
    }

    @Test
    public void getDuplicateWords() {
        List<String> wordsList = new ArrayList<>();
        HashMap<String, Integer> wordCount;
        wordsList.add("жили");
        wordsList.add("жили");
        wordsList.add("себе");
        wordsList.add("дед");
        wordsList.add("да");
        wordsList.add("баба");
        wordsList.add("дед");
        wordsList.add("говорит");
        wordCount = duplicateCounter.countWords(wordsList, wordCountMap);
        assertEquals((Object) 2, wordCount.get("жили"));
        assertEquals((Object) 2, wordCount.get("дед"));
        assertEquals((Object) 1, wordCount.get("да"));
        assertEquals((Object) 1, wordCount.get("говорит"));
    }
}
