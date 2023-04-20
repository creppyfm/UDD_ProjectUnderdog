package PairProgrammingSessions;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _21_Dec_23_2022 {
    public static void main(String[] args) throws IOException {
        System.out.println(mapsOccurrences("The Eagles will win the super bowl!"));
    }

    public static HashMap<Character, Integer> mapsOccurrences (String phrase) {
        HashMap<Character, Integer> returnMap = new HashMap<>();
        String lowerCasePhrase = phrase.toLowerCase();
        for (int i = 0; i < phrase.length(); i++) {
            Character letter = lowerCasePhrase.charAt(i);
            if (!returnMap.containsKey(letter)) {
                returnMap.put(letter, 1);
            } else {
                returnMap.put(letter, returnMap.get(letter) + 1);
            }
        }

        return returnMap;
    }
}