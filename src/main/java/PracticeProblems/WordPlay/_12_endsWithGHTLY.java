package PracticeProblems;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.Arrays;

public class _12_endsWithGHTLY {
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
            //initialize arrayList to easily add lines using .add()
            ArrayList<String> array = new ArrayList<>();
            while (reader.hasNextLine()) {
                //initialize storage for line data to be used in conditional
                String line = reader.nextLine();
                //check for target ending
                if (line.endsWith("GHTLY")) {
                    //if true, add line to array
                    array.add(line);
                }
            }
            //convert arrayList to array; return array
            System.out.println(Arrays.toString(array.toArray()));

        } catch (IOException e) {
            System.out.println("See Error Below:");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
