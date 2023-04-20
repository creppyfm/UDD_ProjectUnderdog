package PairProgrammingSessions;
import jdk.swing.interop.SwingInterOpUtils;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;

public class _33_Jan_12_2023 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Paths.get("sowpods.txt"));

        String longestWord = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (hasNoRepeats(line)) {
                if (longestWord.length() < line.length()) {
                    longestWord = line;
                }

            }
        }
        System.out.println(longestWord);
    }

    public static boolean hasNoRepeats(String word) {
        Set<Character> letters = new HashSet<>();
        char[] charArray = word.toCharArray();
        for (char letter : charArray) {
            if (letters.add(letter) == false) return false;
        }
        return true;
    }
}

//What is the longest word that has no repeating letters?