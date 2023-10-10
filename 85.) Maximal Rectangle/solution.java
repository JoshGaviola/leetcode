public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return 0;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;
    int[] heights = new int[cols];
    int maxArea = 0;

    for (int row = 0; row < rows; row++) {
        // Calculate the histogram heights for each row
        for (int col = 0; col < cols; col++) {
            if (matrix[row][col] == '1') {
                heights[col]++;
            } else {
                heights[col] = 0;
            }
        }

        // Calculate the largest rectangle area for each row using the histogram approach
        maxArea = Math.max(maxArea, largestRectangleArea(heights));
    }

    return maxArea;
}

private int largestRectangleArea(int[] heights) {
    int n = heights.length;
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;

    for (int i = 0; i <= n; i++) {
        int h = (i == n) ? 0 : heights[i];

        while (!stack.isEmpty() && h < heights[stack.peek()]) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        stack.push(i);
    }

    return maxArea;
}
