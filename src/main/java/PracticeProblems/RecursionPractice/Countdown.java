package PracticeProblems.RecursionPractice;

public class Countdown {
    public static void main(String[] args) {
        countdownIteratively(10);
        System.out.println("");
        countdownRecursively(10);
    }

    private static void countdownIteratively(int start) {
        while (start > -1) {
            System.out.println(start);
            start--;
        }
    }

    private static void countdownRecursively(int start) {
        System.out.println(start);
        if (start > 0) {
            countdownRecursively(start - 1);
        }
    }
}
