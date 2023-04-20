package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//HW:
//LOOK UP EARLY RETURNS
//REFACTOR 37-40 && 51-53 TO SWITCH STATEMENTS
public class _14_Dec_15_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("sowpods.txt"))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.length() >= 15 && containsOnlyE(line)) {
                    System.out.println(line);
                }

            }

        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public static boolean containsE (char letter) {
        return letter == 'E';
    }

    public static boolean containsAIOU (char letter) {
        switch (letter) {
            case 'A':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }

    public static boolean containsOnlyE (String word) {
        boolean nextLetterE = false;
        boolean nextLetterS = false;
        char[] wordToArray = word.toCharArray();
        for (int i = 0; i < wordToArray.length; i++) {
            char letter = wordToArray[i];
            if (containsAIOU(letter)) return false;
            if (containsE(letter)) {
                switch (wordToArray[i + 1]) {
                    case 'E':
                        nextLetterE = true;
                        break;
                    case 'S':
                        nextLetterS = true;
                        break;
                    default: return false;
                }
//                if (wordToArray[i + 1] == 'E') nextLetterE = true;
//                if (wordToArray[i + 1] == 'S') nextLetterS = true;
//                if (!nextLetterE && !nextLetterS) return false;
            }

        }
        return nextLetterE || nextLetterS;
    }

}