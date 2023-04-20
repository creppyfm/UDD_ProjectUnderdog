package LC;

public class _326_PowerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(28));
    }

    public static boolean isPowerOfThree(int n) {
        //base case
        if (n == 1) return true;
        if (n < 1) return false;
        if (n % 3 != 0) return false;

        //recursive case
        return isPowerOfThree(n / 3);
    }

    public static boolean isPowerOfThreeIterative(int n) {
        int num = n;
        while (num > 1) {
            if (num % 3 != 0) {
                return false;
            }
            num = num / 3;
        }
        return num == 1;
    }
}


