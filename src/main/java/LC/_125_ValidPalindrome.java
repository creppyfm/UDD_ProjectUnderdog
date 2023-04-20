package LC;

public class _125_ValidPalindrome {
    public static void main(String[] args) {
        String inputOne = "A man, a plan, a canal: Panama";
        String inputTwo = "race a car";
        String inputThree = " ";
        String inputFour = ".";
        String inputFive = "aa";

        System.out.println(isPalindrome(inputOne));
        System.out.println("");
        System.out.println(isPalindrome(inputTwo));
        System.out.println("");
        System.out.println(isPalindrome(inputThree));
        System.out.println("");
        System.out.println(isPalindrome(inputFour));
        System.out.println("");
        System.out.println(isPalindrome(inputFive));
    }

    public static boolean isPalindrome(String input) {
        input = input.toLowerCase()
                .replaceAll("[^a-z\\d]", "");

        if (input.isEmpty() || input.equals(" ")) return true;
        int i = 0;
        int j = input.length() - 1;
        while(i <= j) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }
}
