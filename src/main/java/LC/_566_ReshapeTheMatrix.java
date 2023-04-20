package LC;

public class _566_ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] matrix, int row, int col) {
        if (!validInput(matrix, row, col)) return matrix;
        int[][] reshapedMatrix = new int[row][col];
        int newRow = 0;
        int newCol = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                reshapedMatrix[newRow][newCol] = matrix[i][j];
                newCol++;

                if (newCol == col) {
                    newCol = 0;
                    newRow++;
                }
            }
        }

        return reshapedMatrix;
    }

    public boolean validInput(int[][] matrix, int row, int col) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        if (row < 1 || row > 300) return false;
        if ((col < 1) || (col > 300)) return false;
        return ((matrix.length * matrix[0].length) == (row * col));
    }
}
