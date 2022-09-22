package PracticeProblems;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.FileNotFoundException;

public class FIVE_fifteenLettersNoEA {
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
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
