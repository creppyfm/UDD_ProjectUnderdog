package PracticeProblems;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class FOURTEEN_longestNoVowels {
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {

            //initialize storage for words that do not contain any vowels
            ArrayList<String> noVowels = new ArrayList<>();

            while (reader.hasNextLine()) {
                //initialize storage for line data to be passed to
                //'containsNoVowels' method
                String line = reader.nextLine();
                //check each line for vowels;
                if (containsNoVowels(line)) {
                    //store target words in 'noVowels'
                    noVowels.add(line);
                }
            }

            //initialize storage for longest word with no vowels
            String longestNoVowels = noVowels.get(0);

            //iterate over all elements in noVowels, storing longest
            //word containing no vowels
            for (String string: noVowels) {
                if (string.length() > longestNoVowels.length()) {
                    longestNoVowels = string;
                }
            }

            //return longest word containing no vowels
            System.out.println(longestNoVowels);

        } catch (IOException e) {
            System.out.println("See Error Below:");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    //checks for vowels in lines
    public static Boolean containsNoVowels (String line) {
        return !line.contains("A") &&
                !line.contains("E") &&
                !line.contains("I") &&
                !line.contains("O") &&
                !line.contains("U");
    }
}
