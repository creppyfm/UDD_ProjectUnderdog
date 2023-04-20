package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class _35_Jan_16_2023_HW {
    public static void main(String[] args) throws IOException {
        List<String> returnList = new ArrayList<>();
        Scanner scanner = new Scanner(Paths.get("sowpods.txt"));

        long startTiming = System.nanoTime();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (isLegalWord(line)) {
                returnList.add(line);
            }
        }
        long endTiming = System.nanoTime();
        System.out.println(returnList);
        System.out.println("Duration in Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(endTiming - startTiming));
        System.out.println("Duration in Nanoseconds: " + (endTiming - startTiming));

    }

    public static boolean isLegalWord (String word) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length() - 1; i++) {
            char letterOne = word.charAt(i);
            char letterTwo = word.charAt(i + 1);
            if (letterOne == letterTwo) {
                set.add(letterOne);
            }
        }
        return set.size() >= 3;
    }
}