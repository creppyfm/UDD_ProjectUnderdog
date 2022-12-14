package PracticeProblems;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;

public class _15_leastCommonQXZ {

    public static void main(String[] args) {
        //initialize counters to track occurrences of target letters
        int countQ = 0;
        int countX = 0;
        int countZ = 0;

        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
            while (reader.hasNextLine()) {
                //initialize storage of line data to be passed to 'contains' methods
                String line = reader.nextLine();

                //checks for 'Q'; increments as necessary
                if (containsQ(line)) {
                    countQ++;
                }
                //checks for 'X'; increments as necessary
                if (containsX(line)) {
                    countX++;
                }
                //checks for 'Z'; increments as necessary
                if (containsZ(line)) {
                    countZ++;
                }
            }

            //determine the smaller of the first two letters, Q and X
            int smallestNumber = Math.min(countQ, countX);
            //check Q/X against Z; print least common letter accordingly
            if (smallestNumber < countZ) {
                if (smallestNumber == countQ) {
                    System.out.println("The least common letter is Q: " + countQ + " instances.");
                } else {
                    System.out.println("The least common letter is X:" + countX + " instances.");
                }
            } else {
                System.out.println("The least common letter is Z: " + countZ + " instances.");
            }

        } catch (IOException e) {
            System.out.println("See Error Below:");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    //checks for 'Q' in words
    public static Boolean containsQ (String line) {
        return line.contains("Q");
    }

    //checks for 'X' in words
    public static Boolean containsX (String line) {
        return line.contains("X");
    }

    //checks for 'Z' in words
    public static Boolean containsZ (String line) {
        return line.contains("Z");
    }

}
