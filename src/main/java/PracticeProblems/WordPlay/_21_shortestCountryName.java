package PracticeProblems;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;

public class _21_shortestCountryName {
    public static void main(String[] args) {

        ArrayList<String> countries = new ArrayList<>();
        ArrayList<String> shortestNames = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get("countries.txt"))){

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                countries.add(line);
            }

            String shortestName = countries.get(0);

            for (String line: countries) {
                if (shortestName.length() > line.length()) {
                    shortestName = line;
                }
            }

            int shortestNameLetterCount = shortestName.length();

            for (String line: countries) {
                if (line.length() == shortestNameLetterCount) {
                    shortestNames.add(line);
                }
            }

            System.out.println(shortestNames);

        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
