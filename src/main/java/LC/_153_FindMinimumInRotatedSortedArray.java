package LC;

public class _153_FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];

            if (midVal > nums[right]) {
                left = mid + 1;
            } else if (midVal < nums[right]) {
                right = mid;
            } else {
                return midVal;
            }
        }

        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };
        int minVal = findMin(nums);
        System.out.println(minVal);
    }
}
