package LC;

public class _704_BinarySearchRecursively {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums[nums.length - 1];

        return helper(nums, target, start, end);
    }

    public static int helper(int[] nums, int target, int start, int end) {
        if (start > end) return -1;

        int mid = ((start + end) / 2);
        if (target == nums[mid]) return mid;

        if (target < nums[mid]) {
            return helper(nums, target, start, (mid - 1));
        }

        return helper(nums, target, (mid + 1), end);
    }
}

//Iterative solution:
/*
 public int search(int[] nums, int target) {
     if (nums.length < 1) return -1;

     int i = 0;
     int j = nums.length - 1;
     while (i <= j) {
         int mid = (i + j) / 2;
         if (nums[mid] == target) {
             return mid;
         } else if (nums[mid] < target) {
             i = mid + 1;
         } else {
             j = mid - 1;
         }
     }
     return -1;
 }
*/


