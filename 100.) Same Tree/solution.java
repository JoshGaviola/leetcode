class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both trees are null, they are the same.
        if (p == null && q == null) {
            return true;
        }
        
        // If one of the trees is null, they are not the same.
        if (p == null || q == null) {
            return false;
        }
        
        // If the values at the current nodes are different, the trees are not the same.
        if (p.val != q.val) {
            return false;
        }
        
        // Recursively check if the left and right subtrees are the same.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
