package PracticeProblems;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class _20_moreThanHalfVowels {
    public static void main(String[] args) {

        ArrayList<String> moreThanHalfVowels = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get("countries.txt"))){

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                int dividedWord = wordLengthDivided(line);
                int vowelsCounter = countVowels(line);

                if (vowelsCounter > dividedWord) {
                    moreThanHalfVowels.add(line);
                }

            }

            System.out.println(moreThanHalfVowels);


        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Integer wordLengthDivided (String line) {
        int wordLengthDivided = line.length() / 2;
        return wordLengthDivided;
    }

    public static Integer countVowels (String line) {
        int vowelsCounter = 0;
        line = line.toLowerCase();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'a' ||
                line.charAt(i) == 'e' ||
                line.charAt(i) == 'i' ||
                line.charAt(i) == 'o' ||
                line.charAt(i) == 'u') {

                vowelsCounter++;
            }
        }

        return vowelsCounter;
    }


}
