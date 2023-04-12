package PracticeProblems;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;

public class _6_lessThanFiveContainsBX {
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
            while (reader.hasNextLine()) {
                //storing line data to use later
                String line = reader.nextLine();

                //conditional to verify param. are met
                if (line.length() < 5 &&
                    line.contains("B") &&
                    line.contains("X")) {
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
