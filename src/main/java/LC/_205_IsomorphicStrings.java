package LC;

import java.util.HashMap;
import java.util.Map;

public class _205_IsomorphicStrings {
    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> stMap = new HashMap<>();
        Map<Character, Character> tsMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (stMap.containsKey(sChar) && stMap.get(sChar) != tChar ||
                tsMap.containsKey(tChar) && tsMap.get(tChar) != sChar) {
                return false;
            } else {
                stMap.put(sChar, tChar);
                tsMap.put(tChar, sChar);
            }
        }
        return true;
    }
}


/*
* Logic Breakdown:
*
* The task is to write a boolean method that takes two string inputs, 's' and 't',
* and returns true if the strings are isomorphic and false otherwise. Two strings
* are isomorphic if the letters from one string can be replaced with other letters to
* create the other string and vice versa. Every letter must be replaced (can be replaced by itself,)
* and no two letters can map to the same character.
*
* To solve this problem, we can use two HashMap of type Character, Character (stMap and tsMap).
* stMap will hold each char from s mapped to corresponding chars from t.
* tsMap will hold each char from t mapped to corresponding chars from s.
*
* Now that both maps are created and all characters are mapped, the problem can be solved
* by iterating over the length of both maps (equal,)
*  checking if (stMap.get(s.charAt(i)) == true && stMap.get(s.charAt(i)) != t.charAt(i) ||
*               tsMap.get(t.charAt(i)) == true && tsMap.get(t.charAt(i)) != s.charAt(i))) {
*                   return false;
*           else {
*               stMap.put(s.charAt(i)), t.charAt(i));
*               tsMap.put(t.charAt(i)), s.charAt(i));
*           }
*       return true;
*
* */