package LC;

public class _392_IsSubsequence {
    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";

        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence (String s, String t) {
        if (s.length() == 0) return true;
        int i = 0, j = 0;
        while (j < t.length()) {
            char pointerS = (i < s.length()) ? s.charAt(i) : s.charAt(i - 1);
            char pointerT = t.charAt(j);

            if (i < s.length() && pointerS == pointerT) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}


/*
* Logic Breakdown:
*
* The problem asks for a boolean method that return true if its input string 's' is a subsequence of its input string 't'.
* s is a subsequence of t if t contains all letters that make up s AND the letters are in their original position relative
* to one another. For example: s = "abc", t = "agbrce" returns true, since a, b, and c are all contained in t, and are
* in their same position relative to one another as in s.
*
* The two pointer method works to solve this problem. We set one pointer equal to s.charAt(i) and
* the other set to t.charAt(j).
*
* While j < t.length, we iterate over the length of t, checking if our pointerT is equivalent to our pointerS AND if i < s.length.
*       --> yes: increment i and j (push pointers forward)
* Then we can simply return i == s.length; If yes, that means we were able to find all letters from s in t
* */