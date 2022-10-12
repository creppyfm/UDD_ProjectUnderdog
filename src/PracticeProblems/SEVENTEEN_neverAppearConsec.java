package PracticeProblems;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class SEVENTEEN_neverAppearConsec {
    public static void main (String[] args) {

        ArrayList<String> lines = new ArrayList<>();

        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))){

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                lines.add(line);
            }

        } catch (IOException e) {
            System.out.println("See Error Below:");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static Boolean appearsConsecutively (String line) {
        return false;
    }
}
