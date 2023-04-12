package PracticeProblems;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class _22_onlyOneVowel {
    public static void main(String[] args) {

        ArrayList<String> countries = new ArrayList<>();
        ArrayList<String> onlyOneVowel = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get("countries.txt"))){

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                countries.add(line);
            }

            Character vowelToBeCompared = countries.get(0).charAt(0);

            for (String line: countries) {
                for (int i = 0; i < line.length() - 1; i++) {
                    if (isVowel(line.charAt(i))) {
                        vowelToBeCompared = line.charAt(i);

                    }
                }
            }


            System.out.println(onlyOneVowel);

        } catch (IOException e) {
            System.out.println("See Error Below");
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

    public static Boolean isVowel(char letter) {
        String vowel = "aeiou";
        ArrayList<Character> vowels = new ArrayList<>();
        for (int i = 0; i < vowel.length(); i++) {
            vowels.add(vowel.charAt(i));
        }

        return  vowels.contains(letter);
    }
}
