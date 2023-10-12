class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is unbalanced, so the whole tree is unbalanced.
        }

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is unbalanced, so the whole tree is unbalanced.
        }

        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1) {
            return -1; // Tree is unbalanced at this node.
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
