package LC;

public class _74_SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        var target = 10;
        boolean exists = binarySearch(matrix, target);
        System.out.println(exists);
    }

    private static boolean binarySearch(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int left = 0;
        int right = (matrix.length * matrix[0].length) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            /**
             * When solving 'number of islands', I converted the ordered pairs
             * to a single integer index for storage in the queue, then converted
             * that index back to the ordered pair to access elements
             * in the matrix.
             *
             * I noticed I could leverage the second half of that strategy to
             * determine the midpoint of a matrix, using 'mid' as the index.
             */
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                right = mid - 1;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}
