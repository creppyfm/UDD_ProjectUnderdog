package PracticeProblems.RecursionPractice;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        List<Integer> test1 = new ArrayList<>();
        test1.add(2);
        test1.add(3);
        test1.add(6);
        test1.add(7);

        int target = 7;

        System.out.println(comboSum(test1, target));
    }

    private static List<List<Integer>> comboSum(List<Integer> candidates, int target) {
        int index = 0;
        comboHelper(candidates, target, index);
        return returnList;
    }

    private static void comboHelper (List<Integer> candidates, int target, int index) {
        if (target == 0) {
            returnList.add(new ArrayList<>(possibleCandidates));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.size(); i++) {
            possibleCandidates.add(candidates.get(index));
            comboHelper(candidates, (target - candidates.get(index)), i);
            possibleCandidates.remove(possibleCandidates.size() - 1);
        }

    }

    private static List<List<Integer>> returnList = new ArrayList<>();
    private static List<Integer> possibleCandidates = new ArrayList<>();
}

/*
* Problem: Combination Sum
* Description: Given an array of distinct integers candidates and a target integer target,
*               return a list of all unique combinations of candidates where the chosen numbers sum to target.
*               You may return the combinations in any order.
*
* Notes: The same number may be chosen from candidates an unlimited number of times.
*           Two combinations are unique if the frequency of at least one of the chosen numbers is different.
*
* Constraints:
*   1 <= candidates.length <= 30
*   1 <= candidates[i] <= 200
*   All elements of candidates are distinct.
*   1 <= target <= 500
* */
