package PracticeProblems;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;

public class _19_beginAndEndWithVowel {
    public static void main(String[] args) {

        ArrayList<String> beginsAndEndsWithVowels = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get("countries.txt"))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (startsWithVowel(line) &&
                    endsWithVowel(line)) {

                    beginsAndEndsWithVowels.add(line);
                }
            }

            System.out.println(beginsAndEndsWithVowels);

        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }

    public static Boolean startsWithVowel (String line) {

        if (line.startsWith("A") ||
            line.startsWith("E") ||
            line.startsWith("I") ||
            line.startsWith("O") ||
            line.startsWith("U")) {

            return true;
        }
        return false;
    }

    public static Boolean endsWithVowel (String line) {

        if (line.endsWith("a") ||
            line.endsWith("e") ||
            line.endsWith("i") ||
            line.endsWith("o") ||
            line.endsWith("u")) {

            return true;
        }
        return false;
    }
}
