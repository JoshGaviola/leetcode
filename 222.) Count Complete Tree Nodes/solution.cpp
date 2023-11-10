class Solution {
public:
    int countNodes(TreeNode* root) {
        if (!root)
            return 0;

        int leftDepth = 0, rightDepth = 0;
        TreeNode* leftNode = root, *rightNode = root;

        while (leftNode) {
            leftDepth++;
            leftNode = leftNode->left;
        }

        while (rightNode) {
            rightDepth++;
            rightNode = rightNode->right;
        }

        if (leftDepth == rightDepth)
            return pow(2, leftDepth) - 1;

        return 1 + countNodes(root->left) + countNodes(root->right);
    }
};