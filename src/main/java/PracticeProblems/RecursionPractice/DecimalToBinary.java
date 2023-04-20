package PracticeProblems.RecursionPractice;

public class DecimalToBinary {
    public static void main(String[] args) {
        int decimal = 233;
        String result = decimalToBinary(decimal, "");
    }

    private static String decimalToBinary(int n, String result) {
        /*
        What is my base case? What is the smallest input I can manipulate?
        At what point do I end recursion? The smallest input integer is 0.
        If the input is 0, we return result, since we have no more integers to
        convert to binary.
        */
        if (n == 0) return result;

        /*
        What is the smallest unit I can manipulate? In this example,
        the smallest unit to manipulate on each delegation is n (input integer.)
        We take n mod 2, concatenate the resulting integer to result, and return another
        call to the method. This time, we pass n / 2 (approaching base case,)
        along with result.
        */
        result = (n % 2) + result;
        return decimalToBinary((n / 2), result);
    }
}
