package LC;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class _566_ReshapeTheMatrixTest extends _566_ReshapeTheMatrix {

    @Test
    @DisplayName("[ [124753689] ]_PASS")
    void testMatrixReshape_3x3To1x9() {
        int row = 1;
        int col = 9;
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] reshapedMatrix = matrixReshape(matrix, row, col);
        assertEquals(1, reshapedMatrix.length);
        assertEquals(9, reshapedMatrix[0].length);

        int i = 0;
        int[] comparison = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        while (i < reshapedMatrix[0].length) {
            assertEquals(comparison[i], reshapedMatrix[0][i]);
            i++;
        }
    }
    @Test
    @DisplayName("ReturnOriginal_PASS")
    void testMatrixReshape_ReturnOriginal() {
        int row = 0;
        int col = 9;
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] reshapedMatrix = matrixReshape(matrix, row, col);
        assertEquals(3, reshapedMatrix.length);
        assertEquals(3, reshapedMatrix[0].length);

        assertEquals(matrix, matrixReshape(matrix, row, col));
    }
    @Test
    @DisplayName("[ [124753689] ]_PASS")
    void testMatrixReshape_3x3To3x3() {
        int row = 3;
        int col = 3;
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] reshapedMatrix = matrixReshape(matrix, row, col);
        assertEquals(3, reshapedMatrix.length);
        assertEquals(3, reshapedMatrix[0].length);

        List<Integer> originalMatrixVals = rowOrderTraversal(matrix);
        List<Integer> reshapedMatrixVals = rowOrderTraversal(reshapedMatrix);

        for (int i = 0; i < originalMatrixVals.size(); i++) {
            int originalVal = originalMatrixVals.get(i);
            int reshapedVal = reshapedMatrixVals.get(i);
            assertEquals(originalVal, reshapedVal);
        }
    }

    private List<Integer> rowOrderTraversal(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> valueList = new ArrayList<>(m * n);
        for (int[] row : matrix) {
            for (int num : row) {
                valueList.add(num);
            }
        }
        return valueList;
    }


    @Test
    @DisplayName("True_PASS")
    void testValidInput_ValidInput() {
        int row = 1;
        int col = 9;
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        assertTrue(validInput(matrix, row, col));
    }
    @Test
    @DisplayName("False_PASS")
    void testValidInput_InvalidMatrixCols() {
        int row = 1;
        int col = 9;
        int[][] matrix = {
                { }
        };

        assertFalse(validInput(matrix, row, col));
    }
    @Test
    @DisplayName("False_PASS")
    void testValidInput_InvalidMatrixRows() {
        int row = 1;
        int col = 9;
        int[][] matrix = { };

        assertFalse(validInput(matrix, row, col));
    }

    @Test
    @DisplayName("False_PASS")
    void testValidInput_InvalidRowVal() {
        int row = 0;
        int col = 9;
        int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        assertFalse(validInput(matrix, row, col));
    }
    @Test
    @DisplayName("False_PASS")
    void testValidInput_InvalidColVal() {
        int row = 1;
        int col = 0;
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        assertFalse(validInput(matrix, row, col));
    }

}