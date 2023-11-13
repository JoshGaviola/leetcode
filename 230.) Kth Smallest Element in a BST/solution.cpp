/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        stack<TreeNode*> nodes;

        int count = 0;

        while (root || !nodes.empty()) {
            while (root) {
                nodes.push(root);
                root = root->left;
            }
            root = nodes.top();
            nodes.pop();
            count++;
            if (count == k) {
                return root->val;
            }
            root = root->right;
        }
        return -1;
    }
};