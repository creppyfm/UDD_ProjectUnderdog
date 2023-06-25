package LC;

import java.util.Arrays;

public class _79_WordSearch {
    public static void main(String[] args) {
        char[][] boardOne = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        char[][] boardTwo = {
                { 'a', 'a' }
        };
        char[][] boardThree = {
                { 'C', 'A', 'A' },
                { 'A', 'A', 'A' },
                { 'B', 'C', 'D' }
        };

        String wordOne = "ABCCED";
        String wordTwo = "SEE";
        String wordThree = "ABCB";
        String wordFour = "aaa";
        String wordFive = "AAB";

        System.out.println(exist(boardOne, wordOne)); //true
        System.out.println(exist(boardOne, wordTwo)); //true
        System.out.println(exist(boardOne, wordThree)); //false
        System.out.println(exist(boardTwo, wordFour)); //false
        System.out.println(exist(boardThree, wordFive)); //true
    }

    private static final int[][] DIRECTIONS = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean found;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char curr = board[i][j];
                if (curr == word.charAt(0)) {
                    found = dfs(board, visited, word, i, j, 0);
                    if (found) return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, boolean[][] visited, String word, int row, int col, int index) {
        if (index == word.length() - 1) return true;

        visited[row][col] = true;

        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (isValid(board, visited, word, newRow, newCol, index + 1)) {
                if (dfs(board, visited, word, newRow, newCol, index + 1)) {
                    return true;
                }
            }
        }

        visited[row][col] = false;
        return false;
    }

    private static boolean isValid(char[][] board, boolean[][] visited, String word, int row, int col, int index) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;

        if (visited[row][col]) return false;

        return board[row][col] == word.charAt(index);
    }
}


/*

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once.

* */