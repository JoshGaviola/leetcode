class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbersDFS(root, 0);
    }

    private int sumNumbersDFS(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        currentSum = currentSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currentSum;
        }

        int leftSum = sumNumbersDFS(node.left, currentSum);
        int rightSum = sumNumbersDFS(node.right, currentSum);

        return leftSum + rightSum;
    }
}
