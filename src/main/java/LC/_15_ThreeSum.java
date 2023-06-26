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

