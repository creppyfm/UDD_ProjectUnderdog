package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;


public class _3_Dec_1_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("countries.txt"))) {

            ArrayList<String> greaterThan50Vowels = new ArrayList<>();
            String vowels = "eaiouEAIOU";

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int countVowels = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (vowels.contains(
                        String.valueOf(
                        line.charAt(i)))) {
                                countVowels++;
                    }
                }
                if ((countVowels * 2 > line.length())) {
                    greaterThan50Vowels.add(line);
                }
            }
            //print final result
            System.out.println(greaterThan50Vowels);

        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

//    public static boolean isVowel (char letter) {
//        letter = Character.toLowerCase(letter);
//        return letter == 'a' ||
//                letter == 'e' ||
//                letter == 'i' ||
//                letter == 'o' ||
//                letter == 'u';
//    }

//refactor without isVowel hard-coded -
//refactor without countLetters - DONE
//refactor without words ArrayList - DONE