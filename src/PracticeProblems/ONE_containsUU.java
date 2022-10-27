package PracticeProblems;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;

public class ONE_containsUU {
    public static void main(String[] args) {
        //initialize reader
        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
            //iterate through file until all lines are read
            while (reader.hasNextLine()) {
                //store line contents
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
