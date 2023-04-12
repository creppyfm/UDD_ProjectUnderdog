package PracticeProblems;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;

public class _3_containsQNotU {
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
            while (reader.hasNextLine()) {
                //storage for line data to be used later
                String line = reader.nextLine();
                //conditional verifies parameters are met so only
                //words containing Q but not U, are returned
                if (line.contains("Q") && !line.contains("U")) {
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
