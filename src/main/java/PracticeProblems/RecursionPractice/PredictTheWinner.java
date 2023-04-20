package PracticeProblems.RecursionPractice;

public class PredictTheWinner {
    public static void main(String[] args) {

    }

    public boolean PredictTheWinner(int[] nums) {
        return true;
    }


}

/*
* BC: if (nums.size == 0) return (p1Score >= p2Score));
*
* RC: else
*
*   p1Choice
*   p2Choice
*           if (p1Choice == nums[0] update p1Score, remove nums[0] from nums, call function
*               else: update p1Score, remove nums[0] from nums, call function
*           if (p2Choice == nums[0] update p2Score, remove nums[0] from nums, call function
*               else
*
* private boolean helper (int[] nums, p1Score, p2Score)
* * */
