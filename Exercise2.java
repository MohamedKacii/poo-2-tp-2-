import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Enter a sentence: ");
        String inputSentence = inputScanner.nextLine();

        inputSentence = inputSentence.trim().toLowerCase();

        if (inputSentence.isBlank()) {
            System.out.println("The provided sentence is empty or contains only spaces.");
            inputScanner.close();
            return;
        }

        String[] tokens = inputSentence.split("\\s+");

        Map<String, Integer> wordCounts = new HashMap<>();

        for (String token : tokens) {
            wordCounts.put(token, wordCounts.getOrDefault(token, 0) + 1);
        }

        System.out.printf("%-15s %s\n", "Word", "Occurrences");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.printf("%-15s %d\n", entry.getKey(), entry.getValue());
        }

        System.out.println("Total word count: " + tokens.length);
        System.out.println("Distinct word count: " + wordCounts.size());

        String mostFrequentWord = null;
        int highestCount = 0;

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > highestCount) {
                highestCount = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }
        System.out
                .println("The most frequent word is '" + mostFrequentWord + "' (appeared " + highestCount + " times).");

        List<String> sortedWords = new ArrayList<>(wordCounts.keySet());
        Collections.sort(sortedWords);

        for (String word : sortedWords) {
            System.out.println("- " + word);
        }

        inputScanner.close();
    }
}
