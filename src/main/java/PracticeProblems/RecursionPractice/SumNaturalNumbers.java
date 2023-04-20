package PracticeProblems.RecursionPractice;

public class SumNaturalNumbers {
    public static void main(String[] args) {
        int n = sumNaturalNumbers(10);
        System.out.println(n);
    }

    private static int sumNaturalNumbers(int n) {
        /*
        What is my base case? What is the smallest input I can work on?
        In this example, the smallest valid input is 0.
        */
        if (n <= 1) return n; //we have summed every other number

        /*
        What is the smallest unit I can manipulate? By reducing n
        by 1 each call, we can shrink the input to eventually match
        the base case (<= 1).
        */
        return n + sumNaturalNumbers(n - 1); //add input to sum of input - 1
    }
}
