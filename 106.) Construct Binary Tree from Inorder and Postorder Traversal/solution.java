class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public TreeNode buildTree(int[] inorder, int[] postorder) {
    return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
}

private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
    if (inStart > inEnd) {
        return null;
    }

    int rootVal = postorder[postEnd];
    TreeNode root = new TreeNode(rootVal);

    int rootIndex = inStart;
    while (inorder[rootIndex] != rootVal) {
        rootIndex++;
    }

    int rightSize = inEnd - rootIndex;

    root.left = buildTreeHelper(inorder, inStart, rootIndex - 1, postorder, postStart, postEnd - rightSize - 1);
    root.right = buildTreeHelper(inorder, rootIndex + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);

    return root;
}