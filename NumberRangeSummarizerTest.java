import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;

public class NumberRangeSummarizerTest {
    
    @Test
    public void testCollect() {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImp();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> expectedOutput = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        Collection<Integer> actualOutput = summarizer.collect(input);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testSummarizeCollection() {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImp();
        Collection<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String expectedOutput = "1, 3, 6-8, 12-15, 21-24, 31";
        String actualOutput = summarizer.summarizeCollection(input);
        assertEquals(expectedOutput, actualOutput);
    }
}
