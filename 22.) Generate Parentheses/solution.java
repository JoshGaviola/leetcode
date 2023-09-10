import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, n, "", result);
        return result;
    }

    private void generateParenthesisHelper(int left, int right, String current, List<String> result) {
        // Base case: If both left and right parentheses are used up, add the current combination to the result.
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }

        // Recursive cases:
        // Add a left parenthesis if there are still available left parentheses.
        if (left > 0) {
            generateParenthesisHelper(left - 1, right, current + "(", result);
        }

        // Add a right parenthesis if it creates a valid combination (more left than right).
        if (right > left) {
            generateParenthesisHelper(left, right - 1, current + ")", result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        List<String> result = solution.generateParenthesis(n);
        System.out.println(result);
    }
}
