public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        
        // Check if it's a leaf node and if its value equals the remaining targetSum.
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        
        // Recursively check the left and right subtrees.
        boolean leftPath = hasPathSum(root.left, targetSum - root.val);
        boolean rightPath = hasPathSum(root.right, targetSum - root.val);
        
        return leftPath || rightPath;
    }
}
