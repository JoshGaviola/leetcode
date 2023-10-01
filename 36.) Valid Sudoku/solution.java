class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Initialize sets to check for uniqueness in rows, columns, and sub-grids.
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] subGrids = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            subGrids[i] = new HashSet<>();
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                
                if (current == '.') {
                    continue; // Skip empty cells
                }
                
                // Check row
                if (!rows[i].add(current)) {
                    return false; // Duplicate in the same row
                }
                
                // Check column
                if (!cols[j].add(current)) {
                    return false; // Duplicate in the same column
                }
                
                // Check sub-grid
                int subGridIndex = (i / 3) * 3 + j / 3;
                if (!subGrids[subGridIndex].add(current)) {
                    return false; // Duplicate in the same sub-grid
                }
            }
        }
        
        return true; // All rules are satisfied
    }
}
