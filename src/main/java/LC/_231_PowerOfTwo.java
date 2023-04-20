package LC;

public class _231_PowerOfTwo {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(isPowerOfTwo(n));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;

        if (n % 2 == 0 && n != 0) {
            n = (n / 2);
            return isPowerOfTwo(n);
        }
        return false;
    }
}
