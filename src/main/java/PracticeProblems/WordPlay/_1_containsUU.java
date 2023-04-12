package PracticeProblems;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;

public class _1_containsUU {
    public static void main(String[] args) {

        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {

            while (reader.hasNextLine()) {
                //store line contents for use later
                String line = reader.nextLine();
                //check for target char sequence; return results
                if(line.contains("UU")) {
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
