package PracticeProblems;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.FileNotFoundException;

public class NINE_containsAllFiveVowels {
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
            while (reader.hasNextLine()) {
                //storing line data for later use
                String line = reader.nextLine();

                //conditional to verify 'all vowels' param. is met
                if (line.contains("A") &&
                    line.contains("E") &&
                    line.contains("I") &&
                    line.contains("O") &&
                    line.contains("U")) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("See Error Below:");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
