package PracticeProblems;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class _18_containsUnited {
    public static void main(String[] args) {

        ArrayList<String> containsUnited = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get("countries.txt"))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.contains("United")) {
                    containsUnited.add(line);
                }
            }

            System.out.println(containsUnited);


        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
