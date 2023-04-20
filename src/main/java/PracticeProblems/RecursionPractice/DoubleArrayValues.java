package PracticeProblems.RecursionPractice;

import java.util.Arrays;

public class DoubleArrayValues {
    public static void main(String[] args) {
        int[] numsA = { 1, 2, 3, 4, 5 };
        int[] numsB = { 1, 2, 3, 4, 5 };
        int index = 0;
        System.out.println(Arrays.toString(doubleArrayIteratively(numsA, 0)));
        System.out.println("");
        System.out.println(Arrays.toString(doubleArrayRecursively(numsB, 0)));
    }

    private static int[] doubleArrayIteratively(int[] nums, int index) {
        while (index <= nums.length - 1) {
            nums[index] = nums[index] * 2;
            index++;
        }
        return nums;
    }

    private static int[] doubleArrayRecursively(int[] nums, int index) {
        if (index > nums.length - 1) {
            return nums;
        } else {
            nums[index] *= 2;
            return doubleArrayRecursively(nums, index + 1);
        }
    }
}
