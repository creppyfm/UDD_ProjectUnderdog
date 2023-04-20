package PracticeProblems.RecursionPractice;

public class ReverseString {
    public static void main(String[] args) {
        String input = "hello";
        System.out.println(reverseString(input));
    }

    private static String reverseString(String input) {
        /*
        What is the base case? (When can I no longer continue?)
        In this case, the smallest input possible is an empty string.
        If the input is an empty string, return the input.
        */
        if (input.equals("")) {
            return "";
        }

        /*
        What is the smallest amount of work I can do in each delegation?
        (What is the smallest unit I can reverse?)
        In this case, what is the way I can get from input.equals("some string")
        to input.equals("").
        The smallest unit that can be manipulated in this case is a char.
        */
        return reverseString(input.substring(1)) + input.charAt(0);

    }
}
