class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solveNQueensHelper(result, board, 0, n);
        return result;
    }
    
    private void solveNQueensHelper(List<List<String>> result, char[][] board, int row, int n) {
        if (row == n) {
            result.add(constructSolution(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isValidMove(board, row, col, n)) {
                board[row][col] = 'Q';
                solveNQueensHelper(result, board, row + 1, n);
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
    
    private List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
}
