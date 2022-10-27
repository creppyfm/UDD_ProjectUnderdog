package PracticeProblems;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class THIRTEEN_shortestContainsAllFiveVowels {
    public static void main(String[] args) {
      try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {
          //initialize storage for words that contain all five vowels
          ArrayList<String> allVowels = new ArrayList<>();

          //iterate through txt file, storing target values to 'allVowels'
          while (reader.hasNextLine()) {
              String line = reader.nextLine();

              if (containsAllVowels(line)) {
                  allVowels.add(line);
              }
          }

          //initialize variable to store shortest word
          String shortest = allVowels.get(0);

          //iterate over elements in 'allVowels'
          for (String string: allVowels) {
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




