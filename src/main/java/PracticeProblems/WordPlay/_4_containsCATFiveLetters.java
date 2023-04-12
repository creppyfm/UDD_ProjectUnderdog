package PracticeProblems;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;

public class _4_containsCATFiveLetters {
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
            while (reader.hasNextLine()) {
                //storage for line data to be used later
                String line = reader.nextLine();
                //conditional to verify parameters are met so
                //only words containing CAT that are less than 5
                //characters are returned
                if (line.contains("CAT") && line.length() == 5) {
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
