package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class _6_Dec_5_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("countries.txt"))) {

            ArrayList<String> returnArray = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!multipleVowels(line)) {
                    returnArray.add(line);
                }
            }
            //print final result
            System.out.println(returnArray);

        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public static boolean isVowel (String letter) {
        String vowels = "AEIOUaeiou";
        if (vowels.contains(letter)) {
            return true;
        }
        return false;
    }

    public static boolean multipleVowels (String line) {
        char vowelOne = Character.MIN_VALUE;
        for (int i = 0; i < line.length(); i++) {
            char curr = line.charAt(i);
            if (isVowel(String.valueOf(curr))) {
                if (vowelOne == Character.MIN_VALUE) {
                    vowelOne = curr;
                } else {
                    if (vowelOne != curr) {
                        return true;
                    } else {
                        vowelOne = curr;
                    }
                }
            }
        }
        return false;
    }


}