package LC;

import java.text.CollationElementIterator;
import java.util.Arrays;
import java.util.Collections;

public class _498_DiagonalTraverse {

    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0) return new int[0];

        int m = mat.length;
        int n = mat[0].length;
        int mBound = m - 1;
        int nBound = n - 1;
        int[] returnArr = new int[m * n];
        int i = 0, row = 0, col = 0;
        while (i < (m * n)) { //could be 'for' instead
            returnArr[i] = mat[row][col];
            if (goingUp(row, col)) {
                if (col == nBound) { //start with col, or col will reach right bound
                    row = row + 1;
                } else if (row == 0) {
                    col = col + 1;
                } else {
                    row = row - 1;
                    col = col + 1;
                }

            } else {
                if (row == mBound) { //start with row, or row will reach lower bound
                    col = col + 1;
                } else if (col == 0) {
                    row = row + 1;
                } else {
                    row = row + 1;
                    col = col - 1;
                }
            }
            i = i + 1;
        }
        return returnArr;
    }

    private static boolean goingUp(int row, int col) {
        return (row + col) % 2 == 0;
    }
}

/*

return arr
    add curr to return arr

* if edge going up/right - turn around
* if edge going down/left - continue
*
* end point = (size of row - 1, size of col - 1)
*
*
* */