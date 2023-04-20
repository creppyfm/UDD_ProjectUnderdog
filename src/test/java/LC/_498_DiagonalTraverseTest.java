package LC;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _498_DiagonalTraverseTest extends _498_DiagonalTraverse {

    @Test
    @DisplayName("124753689_TRUE")
    void testFindDiagonalOrder_ReturnsArrayElementsInOrder() {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[] test = findDiagonalOrder(matrix);
        int[] comparison = { 1, 2, 4, 7, 5, 3, 6, 8, 9 };
        assertEquals(test.length, comparison.length);

        int i = 0;
        while (i < comparison.length) {
            assertEquals(comparison[i], test[i]);
            i = i + 1;
        }
    }
}