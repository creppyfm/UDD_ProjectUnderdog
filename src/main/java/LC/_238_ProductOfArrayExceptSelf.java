package LC;

import java.util.Arrays;

public class _238_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] example = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(productExceptSelf(example)));
    }

    public static int[] productExceptSelf (int[] nums) {
        int[] returnArr = new int[nums.length];
        int[] prefixArr = new int[nums.length];
        int[] suffixArr = new int[nums.length];

        //first pass - build prefixArr
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                int product = (prefixArr[i - 1] * nums[i]);
                prefixArr[i] = product;
            } else {
                prefixArr[i] = nums[i];
            }
        }
        //second pass - build suffixArr
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                suffixArr[i] = nums[i];
            } else {
                int product = (suffixArr[i + 1] * nums[i]);
                suffixArr[i] = product;
            }
        }

        //third pass - build returnArr
        for (int i = 0; i <= nums.length - 1; i++) {
            int j = nums.length - 2;
            if (i <= 0 || i > j) {
                if (i == nums.length - 1) {
                    returnArr[i] = prefixArr[i - 1];
                } else if (i == 0) {
                    returnArr[i] = suffixArr[i + 1];
                }
            } else {
                int product = (prefixArr[i - 1] * suffixArr[i + 1]);
                returnArr[i] = product;
            }
        }
        return returnArr;
    }
}

/*
* -product of each element excluding nums[i]
* -
* */
