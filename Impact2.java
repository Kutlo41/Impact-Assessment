package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Impact2 {
    public static void main(String args[]) {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> numbers = collect(input);
        String summary = summarizeCollection(numbers);
        System.out.println(summary);
    }

    public static Collection<Integer> collect(String input) {
        String[] num = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : num) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

    public static String summarizeCollection(Collection<Integer> input) {
        List<Integer> sorted = new ArrayList<>(input);
        Collections.sort(sorted);

        StringBuilder output = new StringBuilder();
        int i = 0;
        while (i < sorted.size()) {
            int start = sorted.get(i);
            int end = start;
            while (i < sorted.size() - 1 && sorted.get(i + 1) == end + 1) {
                end = sorted.get(i + 1);
                i++;
            }
            if (start == end) {
                output.append(start);
            } else {
                output.append(start).append("-").append(end);
            }
            if (i < sorted.size() - 1) {
                output.append(", ");
            }
            i++;
        }
        return output.toString();
    }

    public interface NumberRangeSummarizer {
        // collect the input
        Collection<Integer> collect(String input);

        // get the summarized string
        String summarizeCollection(Collection<Integer> input);
    }
}
