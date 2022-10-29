package PracticeProblems;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.FileNotFoundException;

public class SEVEN_startsAndEndsWithY {
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
            while (reader.hasNextLine()) {
                //storing line data to use later
                String line = reader.nextLine();
                //conditional to verify param. are met
                if (line.startsWith("Y") &&
                    line.endsWith("Y")) {
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
