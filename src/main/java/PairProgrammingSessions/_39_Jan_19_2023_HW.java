package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class _39_Jan_19_2023_HW {
    public static void main(String[] args) throws IOException {
        Set<String> words = new HashSet<>();
        Scanner scanner = new Scanner(Paths.get("sowpods.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            words.add(line);
        }

        long startTiming = System.nanoTime();
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
        long endTiming = System.nanoTime();

        for (Map.Entry kvPair : compoundToSubstrings.entrySet()) {
            System.out.println(kvPair);
        }

        System.out.println("Duration in Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(endTiming - startTiming));
        System.out.println("Duration in Nanoseconds: " + (endTiming - startTiming));

    }

    private static final Map<String, List<String>> compoundToSubstrings = new HashMap<>();
}

/*
* HOMEWORK
* - FURTHER OPTIMIZATION
* - TIMING - DONE
*
* */