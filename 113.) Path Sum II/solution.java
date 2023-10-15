import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, targetSum, result, currentPath);
        return result;
    }
    
    private void findPaths(TreeNode node, int targetSum, List<List<Integer>> result, List<Integer> currentPath) {
        if (node == null) {
            return;
        }
        
        // Add the current node's value to the path.
        currentPath.add(node.val);
        
        // Check if it's a leaf node and if its value equals the remaining targetSum.
        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(currentPath));
        } else {
            // Recursively check the left and right subtrees.
            findPaths(node.left, targetSum - node.val, result, currentPath);
            findPaths(node.right, targetSum - node.val, result, currentPath);
        }
        
        // Remove the current node's value from the path to backtrack.
        currentPath.remove(currentPath.size() - 1);
    }
}
