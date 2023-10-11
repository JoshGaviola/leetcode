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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
}

private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
    if (preStart > preEnd) {
        return null;
    }

    int rootVal = preorder[preStart];
    TreeNode root = new TreeNode(rootVal);

    int rootIndex = inStart;
    while (inorder[rootIndex] != rootVal) {
        rootIndex++;
    }

    int leftSize = rootIndex - inStart;

    root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1);
    root.right = buildTreeHelper(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd);

    return root;
}
}