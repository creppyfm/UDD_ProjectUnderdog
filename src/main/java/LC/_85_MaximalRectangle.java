package LC;

public class _85_MaximalRectangle {
    private static final char[][] INPUT_MATRIX = {
            { '1', '0', '1', '0', '0' },
            { '1', '0', '1', '1', '1' },
            { '1', '1', '1', '1', '1' },
            { '1', '0', '0', '1', '0' }
    };

    public static void main(String[] args) {
        int maxArea = maximalRectangle(INPUT_MATRIX);
        System.out.println(maxArea);
    }

    private static int maximalRectangle(char[][] matrix) {
        return -1;
    }
}
