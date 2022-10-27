package PracticeProblems;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class SEVENTEEN_neverAppearConsec {
    public static void main (String[] args) {

        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> appearsConsecutively = new ArrayList<>();
        ArrayList<String> letters = new ArrayList<>();
        ArrayList<String> doesNotAppearConsecutively = new ArrayList<>();

        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))){

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                lines.add(line);
            }

            //consecutive letters are added to 'appearsConsecutively' to be
            //compared to list of all letters in alphabet
            for (String line: lines) {
                for (int i = 0; i < line.length() - 1; i++) {
                    if (line.charAt(i) == line.charAt(i + 1)) {
                        if (!appearsConsecutively.contains(String.valueOf(line.charAt(i)))) {
                            appearsConsecutively.add(String.valueOf(line.charAt(i)));
                        }
                    }
                }
            }

            //creating list of all unique letters in the alphabet to be
            //compared to list of letters that appear consecutively
            for (String line: lines) {
                for (int i = 0; i < line.length() - 1; i++) {
                    if (!letters.contains(String.valueOf(line.charAt(i)))) {
                        letters.add(String.valueOf(line.charAt(i)));
                    }
                }
            }

            //compare letters of alphabet against letters that appear consecutively
            //to find letters that do not appear consecutively
            for (String letter: letters) {
                if (!appearsConsecutively.contains(letter)) {
                    doesNotAppearConsecutively.add(letter);
                }
            }

            System.out.println(doesNotAppearConsecutively);

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
