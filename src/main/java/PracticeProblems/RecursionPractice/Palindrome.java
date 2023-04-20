package PracticeProblems.RecursionPractice;

public class Palindrome {
    public static void main(String[] args) {
        String input = "kayak";
        System.out.println(isPalindrome(input));
    }

    private static boolean isPalindrome(String input) {
        /*
        What is my base case? At what point do I stop calling isPalindrome?
        In this example, we need to check if input.length() == 1 || if input.length() == 0.
        We are looking at the beginning of the input and comparing to the end of input,
        so for inputs where .length() is odd, we check for .length() == 1. If .length() is even,
        we check for .length() == 0.
        */
        if (input.length() == 1 || input.length() == 0) {
            return true;
        }

        /*
        What is the smallest unit that can be manipulated on each delegation?
        In this example, we are comparing the first and last characters.
        If they are equal, we recurse.
        To make the input smaller each time, we take substring of input from
        index 1 (second char,) to last char (exclusive.)
        */
        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            return isPalindrome(input.substring(1, input.length() - 1));
        }

        /*
        Finally, return false if we don't reach input.length() == 1 || 0, and
        the first and last chars of input don't match. This means we do not
        have a palindromic input.
        */
        return false;
    }
}
