package PracticeProblems;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;

public class _5_fifteenLettersNoEA {
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
            while (reader.hasNextLine()) {
                //storage for line data to be used later
                String line = reader.nextLine();
                //conditional to verify param. are met
                if (line.length() >= 15 &&
                    !line.contains("E") &&
                    !line.contains("A")) {
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
