package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;

public class _38_Jan_19_2023 {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(Paths.get("sowpods.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (containsAllLetters(line)) {
                System.out.println(line);
            }
        }
    }

    public static boolean containsAllLetters (String word) {
        String letterChain = "ABCDEF";
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < letterChain.length(); i++) {
            set.add(letterChain.charAt(i));
        }

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (set.remove(letter) && set.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
