/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxPathSum;
    }

    private int findMaxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        // Calculate the maximum path sum for the left and right subtrees.
        int leftMax = Math.max(0, findMaxPath(node.left));
        int rightMax = Math.max(0, findMaxPath(node.right));
        
        // Update the global maximum path sum considering the current node.
        maxPathSum = Math.max(maxPathSum, leftMax + rightMax + node.val);
        
        // Return the maximum path sum rooted at the current node.
        return Math.max(leftMax, rightMax) + node.val;
    }
}