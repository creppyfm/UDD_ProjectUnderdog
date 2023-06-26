package LC;

import java.util.*;

public class _15_ThreeSum {
    public static void main(String[] args) {
        int[] numsOne = { -1, 0, 1, 2, -1, -4 };
        int[] numsTwo = { 0, 1, 1 };
        int[] numsThree = { 0, 0, 0 };

        System.out.println(threeSum(numsOne)); //[[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(numsTwo)); //[]
        System.out.println(threeSum(numsThree)); //[0,0,0]
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> solutionList = new ArrayList<>();

        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    solutionList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return solutionList;
    }
}


/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k,
and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Three pointers i, j, k
-- i starts at 0, j at i + 1, and k at nums.length - 1
-- while i <= nums.length - 3
-- sum three values
---- if sum < 0: move the smaller of j and k (if j < k: increment j, if k < j: decrement k)
------ else-if sum > 0: move the larger of j and k (if j > k: increment j, if k > j: decrement k)
------ else-if sum == 0: add values from each pointer to new list; sort the list

-- add triplet list to Set<List<Integer>> solutionSet to ensure unique lists
---- if solutionSet.add(list) == false:

-- convert solutionSet to List<List<Integer>> solutionList;
* */