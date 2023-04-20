package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class _2_Nov_29_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("countries.txt"))) {

            ArrayList<String> words = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String upperLine = line.toUpperCase();
                char firstLetter = upperLine.charAt(0);
                char lastLetter = upperLine.charAt(upperLine.length() - 1);

                if (isAVowel(firstLetter) &&
                    isAVowel(lastLetter)) {
                    words.add(line);
                }

            }

            //print final result
            System.out.println(words);


        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public static boolean isAVowel (char chr) {
        return chr == 'A' ||
            chr == 'E' ||
            chr == 'I' ||
            chr == 'O' ||
            chr == 'U';

    }

}