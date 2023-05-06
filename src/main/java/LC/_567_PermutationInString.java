package LC;

import java.util.Arrays;

public class _567_PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        if (s2.length() < s1.length()) return false;

        for (char c : s1.toCharArray()) {
            s1Arr[c - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            s2Arr[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Arr, s2Arr)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            char c = s2.charAt(i);
            int s1Length = s1.length();
            s2Arr[c - 'a']++;
            s2Arr[s2.charAt(i - s1Length) - 'a']--;

            if (Arrays.equals(s2Arr, s1Arr)) return true;
        }

        return false;
    }
}


