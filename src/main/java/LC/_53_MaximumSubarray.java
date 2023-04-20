package LC;

public class _53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = nums[0];
        for (int num : nums) {
            currSum += num;
            maxSum = Math.max(currSum, maxSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}

/*
* 2 ptr
*   left, right
*   sum full array
*       increment lesser value ptr
*           sub val from total sum
*
* */
