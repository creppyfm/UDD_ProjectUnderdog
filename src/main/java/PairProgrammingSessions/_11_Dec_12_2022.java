package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//***************HOMEWORK*********************
//IMPLEMENT SET INSTEAD OF ARRAYLIST FOR O(1) LOOKUP - DONE
//IMPLEMENT TIMING FUNCTION TO TEST SPEED OF ALGORITHM USING SET - DONE (~100X FASTER)
public class _11_Dec_12_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("baby_names_2020_short.txt"))) {

            HashSet<String> names_1880 = readFileToSet("baby_names_1880_short.txt");

            //begin function execution timing
            long startTiming = System.nanoTime();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (names_1880.contains(line)) {
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

    //generate hashset of names from baby_names_1880_short.txt
    //for O(1) lookup when checking for equivalents against
    //baby_names_2020_short.txt
    public static HashSet<String> readFileToSet(String textFile) throws IOException {
        HashSet<String> set = new HashSet<>();

        Scanner scanner = new Scanner(Paths.get(textFile));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            set.add(line);
        }
        return set;
    }

}

