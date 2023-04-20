package LC;

import java.util.Arrays;

public class _724_FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        System.out.println(pivotIndex(nums)); //expected: 3
        int[] nums2 = { 1, 2, 3 };
        System.out.println(pivotIndex(nums2)); //expected: -1
        int[] nums3 = { 2, 1, -1 };
        System.out.println(pivotIndex(nums3)); //expected: 0
        int[] nums4 = { -1,-1,0,1,1,0 };
        System.out.println(pivotIndex(nums4)); //expected: 5

    }

    public static int pivotIndex(int[] nums) {
        int pivotIndex;
        int[] prefixSumArr = new int[nums.length + 1];

        //Create prefix sum array
        for (int i = 0; i < nums.length + 1; i++) {
            if (i > 0) {
                int nextNum = nums[i - 1];
                prefixSumArr[i] = prefixSumArr[i - 1] + nextNum;
            } else {
                int currValue = 0;
                prefixSumArr[i] = currValue;
            }
        }

        //Iterate through prefixSumArr checking for equivalence between left and right
        for (int i = 1; i < prefixSumArr.length; i++) {
            int rightSum = prefixSumArr[prefixSumArr.length - 1] - prefixSumArr[i];
            int leftSum = prefixSumArr[i - 1];
            if (leftSum == rightSum) {
                pivotIndex = i - 1;
                return pivotIndex;
            }
        }

        return -1;
    }
}

/*
* Logic Breakdown:
*
* The task is to find and return the index of input array 'nums',
* where the sum of all integers to the left of nums[index] and the
* sum of all integers to the right of nums[index] are equivalent.
* If no such index exists, return -1;
*
* My approach involves the following:
* First create a prefix sum array of all the prefixSums
* from nums. This is accomplished via the following steps:
* --> creating an int[] prefixSumArr with size equal to length(nums) + 1.
*   --> the extra space allows for the addition of the 0 that always precedes the first element in the array
* --> iterating over nums, storing the sum of each element and the element before it (to the left)
*   --> if i == 0, set prefixSumArr[i] = 0; This is the first element in the array.
*
* Next, iterate over 'prefixSumsArr', checking if the value
* of prefixSumArr[i - 1] is equivalent to the difference of
* prefixSumArr[i] from prefixSumArr[length - 1]. We know the last element of
* prefixSumArr is a sum of every integer from nums. Therefore, by subtracting
* prefixSumArr[i] from the last element, we know the difference is equal to the sum of every
* element to the right of prefixSumArr[i]. Finally, we can compare the element
* to the left of prefixSumArr[i] (sum of all elements to the left,) to the sum of
* all elements to the right of prefixSumArr[i] (the difference from earlier.)
* If the two values match, we know 'i' is our pivotIndex.
*
* */