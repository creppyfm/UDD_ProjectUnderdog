package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;

public class _34_Jan_16_2023 {
    public static void main(String[] args) throws IOException {
        List<String> returnList = new ArrayList<>();
        Scanner scanner = new Scanner(Paths.get("sowpods.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.length() >= 8) {
                if (isLegalWord(line)) returnList.add(line);
            }
        }

        for (String word : returnList) {
            System.out.println(word);
        }
    }

    public static boolean isLegalWord (String line) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            set.add(c);
        }
        return set.size() <= 3;
    }
}