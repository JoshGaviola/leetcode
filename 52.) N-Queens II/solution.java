class Solution {
    public int totalNQueens(int n) {
        int[] count = new int[1]; // To store the count of solutions
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solveNQueensHelper(count, board, 0, n);
        return count[0];
    }
    
    private void solveNQueensHelper(int[] count, char[][] board, int row, int n) {
        if (row == n) {
            count[0]++;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isValidMove(board, row, col, n)) {
                board[row][col] = 'Q';
                solveNQueensHelper(count, board, row + 1, n);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isValidMove(char[][] board, int row, int col, int n) {
        // Check the column above
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        
        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        // Check upper-right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;
    }
}
