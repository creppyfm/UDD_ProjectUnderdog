package LC;

public class _167_TwoSum2_InputArrayIsSorted {
    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;
        int[] solution = twoSum(numbers, target);
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] solution = new int[2];
        int l = 0;
        int r = numbers.length - 1;
        int sum = numbers[l] + numbers[r];

        while (sum != target) {
            if (sum < target) {
                l++;
            } else {
                r--;
            }
            sum = numbers[l] + numbers[r];
        }
        l += 1;
        r += 1;

        solution[0] = l;
        solution[1] = r;

        return solution;
    }
}
