package PracticeProblems;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;

public class ELEVEN_howManyContainTYPE {

    //main code
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
            int count = 0;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
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
        if (string.contains("TYPE")) {
            return true;
        }
        return false;
    }
}
