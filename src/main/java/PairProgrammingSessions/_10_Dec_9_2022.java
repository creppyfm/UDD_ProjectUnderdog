package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//***************HOMEWORK*********************
//IMPLEMENT SET INSTEAD OF ARRAYLIST FOR O(1) LOOKUP - DONE
//IMPLEMENT TIMING FUNCTION TO TEST SPEED OF ALGORITHM USING SET - DONE (~100X SLOWER)
public class _10_Dec_9_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("baby_names_2020_short.txt"))) {

            ArrayList<String> scrabbleWords = scrabbleWords();

            long startTiming = System.nanoTime();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (String word: scrabbleWords) {
                    if (reverseName(line).toUpperCase().equals(word)) {
                        System.out.println(line);
                    }
                }
            }
            long endTiming = System.nanoTime();
            System.out.println("Duration in Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(endTiming - startTiming));
            System.out.println("Duration in Nanoseconds: " + (endTiming - startTiming));
        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> scrabbleWords () {
        ArrayList<String> scrabble = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get("sowpods.txt"))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                scrabble.add(line);
            }

        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return scrabble;
    }

    public static String reverseName (String name) {
        String reversedName = "";
        char letter;

        for (int i = 0; i < name.length(); i++) {
            letter = name.charAt(i);
            reversedName = letter + reversedName;
        }
        return reversedName;
    }

    //                String reverseName = reverseName(line).toUpperCase();
//                for (String word: scrabble) {
//                    if (reverseName.equals(word)) {
//                        returnArray.add(line);
//                    }
//                }


}