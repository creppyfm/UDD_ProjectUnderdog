package PracticeProblems;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;

public class ELEVEN_howManyContainTYPE {

    //main code
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
            //intialize counter to track words that satisfy param.
            int count = 0;
            while (reader.hasNextLine()) {
                //storing line data for later use
                String line = reader.nextLine();
                //conditional verifies param. are met; increments counter
                //if necessary
                if (containsTYPE(line)) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            System.out.println("See Error Below:");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    //checks for target substring
    static Boolean containsTYPE(String string) {
        return string.contains("TYPE");
    }
}
