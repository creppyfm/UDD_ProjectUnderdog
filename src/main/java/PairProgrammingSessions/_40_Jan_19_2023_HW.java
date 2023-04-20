package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class _40_Jan_19_2023_HW {
    public static void main(String[] args) throws IOException {
        Set<String> words = new HashSet<>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Scanner scanner = new Scanner(Paths.get("sowpods.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            words.add(line);
        }
        long startTiming = System.nanoTime();
        String longestSequence = longestSequence(words, alphabet);

        for (String word : words) {
            if (containsAllLetters(word, longestSequence)) {
                System.out.println(word + " contains each character from " + longestSequence);
            }
        }
        long endTiming = System.nanoTime();
        System.out.println("Duration in Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(endTiming - startTiming));
        System.out.println("Duration in Nanoseconds: " + (endTiming - startTiming));

    }

    //longestSequence is passed to containsAllLetters()
    private static String longestSequence (Set<String> words, String alphabet) {
        String sequence = "";
        String longestSequence = "";
        int counter = 0;
        int longestSequenceLength = 0;

        for (String word : words) {
            for (int i = 0; i < alphabet.length(); i++) {
                String letter = String.valueOf(alphabet.charAt(i));
                if (!word.contains(letter)) {
                    if (longestSequenceLength < counter) {
                        longestSequenceLength = counter;
                        longestSequence = sequence;
                    }
                    counter = 0;
                    sequence = "";
                } else {
                    counter++;
                    sequence += letter;
                }
            }
        }

        return longestSequence;
    }

    private static boolean containsAllLetters (String word, String longestSequenceLetters) {
        Set<Character> longestSequence = stringIntoSet(longestSequenceLetters);

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (longestSequence.remove(letter) &&
                    longestSequence.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private static Set<Character> stringIntoSet (String longestSequence) {
        if (longestSequence.length() < 1) return Collections.emptySet();

        Set<Character> longestSequenceSet = new HashSet<>();
        for (int i = 0; i < longestSequence.length(); i++) {
            longestSequenceSet.add(longestSequence.charAt(i));
        }
        return longestSequenceSet;
    }
}

/*
 * HOMEWORK
 * - FURTHER OPTIMIZATION
 * - TIMING - DONE
 * - UNIT TESTING
 *
 * */