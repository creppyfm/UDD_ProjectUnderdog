package LC;

import java.util.Arrays;

public class _1480_RunningSumOf1DArray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(runningSum(nums)));
    }

    public static int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        int sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            runningSum[i] = sum;
            if (i != nums.length - 1) {
                sum += nums[i + 1];
            }
        }
        return runningSum;
    }
}

/*
*
* */
