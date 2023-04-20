package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;

public class _36_Jan_16_2023_HW {
    public static void main(String[] args) throws IOException {
        System.out.println(solutionMethod("AEIOU"));
    }

    public static List<String> solutionMethod (String availableLetters) throws IOException {
        if (availableLetters == null || availableLetters.length() == 0) {
            return Collections.emptyList();
        }
        ArrayList<String> returnArray = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < availableLetters.length(); i++) {
            char c = availableLetters.charAt(i);
            set.add(c);
        }

        Scanner scanner = new Scanner(Paths.get("sowpods.txt"));
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            if (legalWord(word, set)) {
                returnArray.add(word);
            }
        }
        return returnArray;
    }

    public static boolean legalWord (String word, Set<Character> set) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!set.contains(c)) return false;
        }
        return true;
    }
}