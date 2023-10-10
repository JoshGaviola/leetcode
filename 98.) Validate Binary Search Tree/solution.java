public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, TreeNode min, TreeNode max) {
        // Base case: an empty tree is a valid BST.
        if (node == null) {
            return true;
        }

        // Check if the node's value is within the valid range defined by min and max.
        if ((min != null && node.val <= min.val) || (max != null && node.val >= max.val)) {
            return false;
        }

        // Recursively check the left and right subtrees.
        // For the left subtree, the maximum value becomes the current node's value.
        // For the right subtree, the minimum value becomes the current node's value.
        return isValidBST(node.left, min, node) && isValidBST(node.right, node, max);
    }
}
