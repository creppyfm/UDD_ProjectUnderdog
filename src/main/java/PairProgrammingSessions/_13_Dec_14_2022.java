package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;

public class _13_Dec_14_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("sowpods.txt"))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (containsAEIONotU(line)) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public static boolean containsAEIONotU(String word) {
        boolean foundAEIO = false;
        boolean foundU = false;
        char[] wordArray = word.toCharArray();
        for (char letter: wordArray) {
            if (containsU(letter)) {
                foundU = true;
            }

            if (containsAEIO(letter)) {
                foundAEIO = true;
            }
        }
        return !foundAEIO && foundU;
    }

    public static boolean containsAEIO(char letter) {
        return letter == 'A' ||
                letter == 'E' ||
                letter == 'I' ||
                letter == 'O';
    }

    public static boolean containsU (char letter) {
        return letter == 'U';
    }

}