package PracticeProblems;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.FileNotFoundException;

public class TEN_containsAllFiveVowelsAlphabetical {

    //main code
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (containsAllVowels(line) &&
                    vowelsAlphabetical(line)) {
                    System.out.println(line);
                }

            }
        } catch (IOException e) {
            System.out.println("See Error Below:");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    //checks if all vowels are present
    static Boolean containsAllVowels(String string) {
        if (string.contains("A") &&
            string.contains("E") &&
            string.contains("I") &&
            string.contains("O") &&
            string.contains("U")) {
            return true;
        }

        return false;
    }

    //checks if all vowels are in alphabetical order
    static Boolean vowelsAlphabetical(String string) {
        int lineLength = string.length();
        char defaultChar = (char)64;

        for (int i = 0; i < lineLength; i++) {
            if (string.charAt(i) == 'A' ||
                string.charAt(i) == 'E' ||
                string.charAt(i) == 'I' ||
                string.charAt(i) == 'O' ||
                string.charAt(i) == 'U') {

                if (string.charAt(i) < defaultChar) {
                    return false;
                } else {
                    defaultChar = string.charAt(i);
                }
            }
        }

        return true;
    }
}
