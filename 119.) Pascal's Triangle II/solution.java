class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);  // Initialize the first element

        for (int i = 1; i <= rowIndex; i++) {
            // Add a new element for the current row (rightmost element)
            row.add(1);
            
            // Calculate the values for the row in reverse order
            for (int j = row.size() - 2; j > 0; j--) {
                int sum = row.get(j) + row.get(j - 1);
                row.set(j, sum);
            }
        }

        return row;
    }
}
