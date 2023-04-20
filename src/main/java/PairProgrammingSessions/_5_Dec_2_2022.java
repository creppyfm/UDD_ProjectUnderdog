package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class _5_Dec_2_2022 {
    public static void main(String[] args) {

        //fill in .txt filename
        try (Scanner scanner = new Scanner(Paths.get("countries.txt"))) {
            ArrayList<String> noVowels = new ArrayList<>();
            ArrayList<String> countries = new ArrayList<>();
            ArrayList<String> countriesReturn = new ArrayList<>();

            //for assignment of noVowelShortestName value
            boolean firstPass = true;
            String noVowelShortestName = "";

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //to make sure first value isn't compared to itself
                if (firstPass) {
                    //capture value from txt file to be compared to other values
                    noVowelShortestName = stringNoVowels(line);
                    firstPass = false;
                } else {
                    //to find length of the shortest word without vowels for comparison
                    if (noVowelShortestName.length() > stringNoVowels(line).length()) {
                        noVowelShortestName = stringNoVowels(line);
                    }
                }
                //store countries for return; store noVowels for comparison
                countries.add(line);
                noVowels.add(stringNoVowels(line));
            }

            //comparison to find all country names that, without vowels, are equal
            //in length to shortestNameNoVowels length
            for (int j = 0; j < countries.size(); j++) {
                if (noVowelShortestName.length() == noVowels.get(j).length()) {
                    countriesReturn.add(countries.get(j));
                }
            }

            //print final result
            System.out.println(countriesReturn);

        } catch (IOException e) {
            System.out.println();
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    //to create versions of country names without vowels
    //for length comparison
    public static String stringNoVowels (String string) {
        String noVowels = string.replaceAll("[AEIOUaeiou]", "");
        return noVowels;
    }

}

//Write a function that takes as input
// a string (it'll be a country name) and returns the string but with the vowels removed.
//What are the countries that, when you remove all of the vowels, are the
// shortest strings? Your solution should handle ties.