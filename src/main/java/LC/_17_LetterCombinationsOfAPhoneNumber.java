package LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

    private static final String[] lettersArr = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static List<String> letterCombinations(String digits) {
        List<String> returnList = new ArrayList<>();
        if (digits.length() == 0) return returnList;

        String[] currCombo = new String[digits.length()];
        Arrays.fill(currCombo, "0");

        return letterCombinationHelper(0, currCombo, digits, returnList);
    }

    private static List<String> letterCombinationHelper(int index, String[] currCombo, String digits, List<String> returnList) {
        if (index == digits.length()) {
            StringBuilder combination = new StringBuilder();
            for (String string : currCombo) {
                combination.append(string);
            }
            returnList.add(combination.toString());
        } else {
                String letters = lettersArr[Integer.parseInt(String.valueOf(digits.charAt(index)))]; //get current group of letters via current integer
                for (int i = 0; i < letters.length(); i++) {
                    currCombo[index] = String.valueOf(letters.charAt(i));
                    letterCombinationHelper(index + 1, currCombo, digits, returnList);
                }
        }
        return returnList;
    }
}

/*
* Notes
*   Hashmap
*       Int -> String
*   Queue solution:
*
*
* */
