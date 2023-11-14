/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        // Base case: If the root is null or matches either p or q, return the root
        if (!root || root == p || root == q) {
            return root;
        }

        // Recursively search for the LCA in the left and right subtrees
        TreeNode* leftLCA = lowestCommonAncestor(root->left, p, q);
        TreeNode* rightLCA = lowestCommonAncestor(root->right, p, q);

        // If both left and right subtrees contain a node, the current root is the LCA
        if (leftLCA && rightLCA) {
            return root;
        }

        // If only the left subtree contains a node, return its LCA
        return leftLCA ? leftLCA : rightLCA;
    }
};
