package LC;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TimeComplexity: O(m * n) where 'm' represents number of rows in 'grid', and 'n' represents number of columns in 'grid'.
 * SpaceComplexity: O(m * n) where 'm' represents number of rows in 'grid', and 'n' represents number of columns in 'grid'.
 * */
public class _200_NumberOfIslands {

    /*
    * To check all four adjacent coordinates to any given coordinate in a matrix.
    * */
    private static final int[][] DIRECTIONS = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };

    /**
     * Driver method. 'numIslands' visits each coordinate in 'grid'.
     * If a coordinate hasn't been visited and the value at that coordinate
     * is equal to '1', 'numIslands' increments 'n', representing a new island
     * to be added to the count. The method then call 'bfs' to explore any
     * potential neighbors that may be land as well.
     *
     * @param grid the matrix to be traversed- rowLength & colLength are derived from grid
     * @return returns an int 'n', which represents the number of islands found in 'grid'.
     *
     * */
    public static int numIslands(char[][] grid) {
        int n = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];

        //traverse grid; increment numIslands if grid[row][col] == '1'
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    n++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return n;
    }

    /**
     * Performs a breadth-first search from the given coordinate grid[row][col].
     * The method traverses each adjacent neighbor of grid[row][col],
     * adding valid neighboring coordinates to the queue and marking their respective
     * indices in 'visited' as 'true' to avoid traversing a coordinate more that once.
     * This search identifies all the valid land plots that make up a single island.
     *
     * @param grid the matrix currently being traversed
     * @param visited a matrix that holds boolean values representing 'grid' coordinates that have been
     *                (or have not been) visited. Visited[row][col] == 'true' if grid[row][col] has been visited.
     * @param row current row coordinate
     * @param col current col coordinate
     *
     * */
    private static void bfs(char[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        Queue<Integer> queue = new LinkedList<>();
        int start = convertToIndex(grid, row, col);
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int currRow = curr / grid[0].length;
            int currCol = curr % grid[0].length;

            for (int[] dir : DIRECTIONS) {
                int newRow = dir[0] + currRow;
                int newCol = dir[1] + currCol;
                if (isValid(grid, newRow, newCol) && !visited[newRow][newCol]) {
                    int index = convertToIndex(grid, newRow, newCol);
                    queue.add(index);
                    visited[newRow][newCol] = true;
                }
            }
        }
    }

    /**
     * Converts an ordered pair (row, col) into a single Integer index for simpler storage and manipulation.
     *
     * @param row current row coordinate
     * @param col current col coordinate
     * @param grid the matrix currently being traversed- colLength is derived from grid
     * @return     returns a single Integer representation of the ordered pair (row, col).
     *
     * */
    private static int convertToIndex(char[][] grid, int row, int col) {
        int colLength = grid[0].length;
        return row * colLength + col;
    }

    /**
     * Checks that grid[row][col] falls within the bounds of the matrix.
     * If the coordinate is within the bounds of the matrix,
     * 'isValid' checks that grid[row][col] is land (represented by '1').
     *
     * @param row neighboring row coordinate
     * @param col neighboring col coordinate
     * @param grid the matrix currently being traversed- rowLength & colLength are derived from grid
     * @return     returns 'true' if coordinate falls within bounds of the matrix and the value at (row, col) is land ('1'),
     *             and 'false' if any of those conditions are not met.
     *
     * */
    private static boolean isValid(char[][] grid, int row, int col) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        return row < rowLength && row > -1 && col < colLength && col > -1 && grid[row][col] == '1';
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1','1','1','1','0' },
                { '1','1','0','1','0' },
                { '1','1','0','0','0' },
                { '0','0','0','0','0' }
        };
        int numberOfIslands = numIslands(grid);
        System.out.println(numberOfIslands);
    }
}
