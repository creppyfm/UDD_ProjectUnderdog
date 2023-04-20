package LC;

public class _84_LargestRectangleInHistogram {
    private static final int[] heights = { 2, 1, 5, 6, 2, 3 };
    public static void main(String[] args) {

    }

    private static int largestRectangleArea(int[] heights) {
        return -1;
    }
}

/*
    traverse array adding each element to stack
    int maxArea = 0;
    pop elements from stack:
        w = 1
        h = 2
        a = area of w * h = 2

        if maxArea < a -> maxArea == a = 10
         else continue;

         return maxArea
*/