package PracticeProblems;
import java.util.Objects;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;


public class SIXTEEN_longestPalindrome {
    public static void main(String[] args) {

        //initialize list to hold palindromes
        ArrayList<String> palindromes = new ArrayList<>();

        try (Scanner reader = new Scanner(Paths.get("sowpods.txt"))) {

            while (reader.hasNextLine()) {
                //initialize storage for lines from file and
                //their reversed counterparts
                String line = reader.nextLine();
                String lineReverse = reverseString(line);

                //checks equivalence between lines/reversed lines
                if (isPalindrome(line, lineReverse)) {
                    //add palindromes to list to be
                    palindromes.add(line);
                }

            }

            //initialize storage for longest palindrome;
            //set equal to first element in list
            String longestPalindrome = palindromes.get(0);

            //iterate through list of palindromes
            for (String string: palindromes) {
                //compare lengths of elements
                if (string.length() > longestPalindrome.length()) {
                    //set 'longestPalindrome' equal to value of
                    //longest element
                    longestPalindrome = string;
                }
            }

            //return longest palindrome
            System.out.println(longestPalindrome);


        } catch (IOException e) {
            System.out.println("See Error Below:");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    //reverses string; returns reversed string
    public static String reverseString (String line) {
        StringBuilder stringBuild = new StringBuilder(line);
        return stringBuild.reverse().toString();
    }

    //checks if a string is equivalent to itself when reversed
    public static Boolean isPalindrome (String line, String lineReverse) {
        return Objects.equals(line, lineReverse);
    }

}
