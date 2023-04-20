package LC;

import java.util.*;

public class _242_ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
        System.out.println("");
        String u = "rat";
        String v = "cat";
        System.out.println(isAnagram(u, v));
        System.out.println("");
        String w = "a";
        String x = "b";
        System.out.println(isAnagram(w, x));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        List<String> firstStringChars = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            firstStringChars.add(String.valueOf(s.charAt(i)));
        }
        for (int i = 0; i < t.length(); i++) {
            if (!firstStringChars.contains(String.valueOf(t.charAt(i)))) {
                return false;
            } else {
                String c = String.valueOf(t.charAt(i));
                firstStringChars.remove(c);
            }
        }
        return firstStringChars.isEmpty();
    }
}
