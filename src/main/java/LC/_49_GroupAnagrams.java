package LC;

import java.util.*;

public class _49_GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = { "eat", "ate", "tan", "nat", "bat", "tea" };
        List<List<String>> solution = groupAnagrams(strs);
        System.out.println(solution);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> solution = new ArrayList<>();
        if (strs.length == 0) return solution;
        Map<String, List<String>> hashToAnagrams = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] wordChars = strs[i].toCharArray();
            int[] hashArr = new int[26];
            for (char c : wordChars) {
                hashArr[c - 'a']++;
            }
            String hash = Arrays.toString(hashArr);
            List<String> vals;
            if (hashToAnagrams.get(hash) != null) {
                vals = hashToAnagrams.get(hash);
            } else {
                vals = new ArrayList<>();
            }
            vals.add(strs[i]);
            hashToAnagrams.put(hash, vals);
        }
        solution.addAll(hashToAnagrams.values());
        return solution;
    }
}


/*
    Given an array of strings strs, group the anagrams together.
    You can return the answer in any order.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.
* */