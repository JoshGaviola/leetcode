class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    private boolean isMirror(TreeNode leftSubtree, TreeNode rightSubtree) {
        // If both subtrees are null, they are symmetric.
        if (leftSubtree == null && rightSubtree == null) {
            return true;
        }
        
        // If one of the subtrees is null, they are not symmetric.
        if (leftSubtree == null || rightSubtree == null) {
            return false;
        }
        
        // Check if the values of the current nodes are equal and the left subtree of the left subtree is symmetric to the right subtree of the right subtree, and vice versa.
        return (leftSubtree.val == rightSubtree.val) &&
            isMirror(leftSubtree.left, rightSubtree.right) &&
            isMirror(leftSubtree.right, rightSubtree.left);
    }
}
