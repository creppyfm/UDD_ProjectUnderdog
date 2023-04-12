package PracticeProblems;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;

public class _2_containsXYZ {
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
            while (reader.hasNextLine()) {
                //storing line contents for use later
                String line = reader.nextLine();
                //conditional to verify presence of X, Y, and Z to return only
                //words that contain all three
                if (line.contains("X") &&
                    line.contains("Y") &&
                    line.contains("Z")) {
                        System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("See Error Below:");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
