package PracticeProblems;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class THIRTEEN_shortestContainsAllFiveVowels {
    public static void main(String[] args) {
      try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
          //initialize storage for words in txt file
          ArrayList<String> array = new ArrayList<>();

          //iterate through txt file, storing values to 'array'
          while (reader.hasNextLine()) {
              String line = reader.nextLine();
              array.add(line);
          }

          //initialize storage for words that contain all five vowels
          ArrayList<String> arrayVowelWords = new ArrayList<>();

          //iterate over each word in the array
          for (String string:array) {
              //check for all vowels
              if (containsAllVowels(string)) {
                  //add words that contain all vowels
                  arrayVowelWords.add(string);
              }
          }
          //initialize variable to store shortest word
          String shortest = arrayVowelWords.get(0);

          //iterate over elements in 'arrayVowelWords'
          for (String string: arrayVowelWords) {
              //check 'shortest' against every element; assign shorter word to 'shortest' variable
              if (shortest.length() >= string.length()) {
                  shortest = string;
              }
          }

          //return shortest word that contains all five vowels (a, e, i, o, u)
          System.out.println(shortest);

      } catch (IOException e) {
          System.out.println("See Error Below:");
          e.printStackTrace();
          throw new RuntimeException();
      }
    }

    //checks if line contains all five vowels
    public static Boolean containsAllVowels(String line) {
        if (line.contains("A") &&
                line.contains("E") &&
                line.contains("I") &&
                line.contains("O") &&
                line.contains("U")) {
            return true;
        }
        return false;

    }

}




