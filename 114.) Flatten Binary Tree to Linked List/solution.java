public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode mostRight = current.left;
                while (mostRight.right != null) {
                    mostRight = mostRight.right;
                }
                mostRight.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}
