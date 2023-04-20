package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;

public class _37_Jan_17_2023_HW {
    public static void main(String[] args) throws IOException {
        Set<String> words = new HashSet<>();
        Scanner scanner = new Scanner(Paths.get("sowpods.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            words.add(line);
        }

        for (String checkWord : words) {
            String leftWord = String.valueOf(checkWord.charAt(0));
            for (int i = 1; i < checkWord.length(); i++) {
                String right = String.valueOf(checkWord.charAt(i));
                leftWord += right;
                if (words.contains(leftWord) && i < checkWord.length() - 1) {
                    String rightWord = checkWord.substring(i + 1);
                    if (words.contains(rightWord)) {
                        List<String> substrings = new ArrayList<>();
                        substrings.add(leftWord);
                        substrings.add(rightWord);
                        compoundToSubstrings.put(checkWord, substrings);
                        break;
                    }
                }
            }
        }

        for (Map.Entry kvPair : compoundToSubstrings.entrySet()) {
            System.out.println(kvPair);
        }
    }

    private static final Map<String, List<String>> compoundToSubstrings = new HashMap<>();
}

//What are all the compound words?