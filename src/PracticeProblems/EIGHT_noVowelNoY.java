package PracticeProblems;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.FileNotFoundException;

public class EIGHT_noVowelNoY {
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                if (!line.contains("A") &&
                    !line.contains("E") &&
                    !line.contains("I") &&
                    !line.contains("O") &&
                    !line.contains("U") &&
                    !line.contains("Y")) {
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
