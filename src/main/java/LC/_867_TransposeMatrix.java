package LC;

public class _867_TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] matrix2 = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        int[][] transposedMatrix = transpose(matrix2);
        for (int[] row : transposedMatrix) {
            for (int num : row) {
                System.out.print(num);
            }
            System.out.println("");
        }

    }

    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] transposedMatrix = new int[n][m]; //swap n, m for non-square matrix

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }

        return transposedMatrix;
    }
}
