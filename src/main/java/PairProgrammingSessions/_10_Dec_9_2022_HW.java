package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//***************HOMEWORK*********************
//IMPLEMENT SET INSTEAD OF ARRAYLIST FOR O(1) LOOKUP - DONE
//IMPLEMENT TIMING FUNCTION TO TEST SPEED OF ALGORITHM USING SET - DONE (~100X FASTER)
public class _10_Dec_9_2022_HW {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("baby_names_2020_short.txt"))) {

            HashSet<String> names_1880 = names1880();

            //begin function execution timing
            long startTiming = System.nanoTime();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (names_1880.contains(reverseName(line).toUpperCase())) {
                    System.out.println(line);
                }
            }
            //end of function execution timing
            long endTiming = System.nanoTime();
            System.out.println("Duration in Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(endTiming - startTiming));
            System.out.println("Duration in Nanoseconds: " + (endTiming - startTiming));
        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //generate hashset of scrabble words from sowpods.txt
    //for O(1) lookup when checking for equivalents against
    //reversed names
    public static HashSet<String> names1880() throws IOException {
        HashSet<String> scrabble = new HashSet<>();

        Scanner scanner = new Scanner(Paths.get("sowpods.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            scrabble.add(line);
        }

        return scrabble;
    }

    //reverse string passed as parameter for use in comparison
    //against scrabble words
    public static String reverseName(String name) {
        String reversedName = "";
        char letter;

        for (int i = 0; i < name.length(); i++) {
            letter = name.charAt(i);
            reversedName = letter + reversedName;
        }
        return reversedName;
    }
}

