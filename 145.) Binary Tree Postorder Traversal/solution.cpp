#include <vector>
#include <stack>

class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode*> nodeStack;

        if (!root) {
            return result;
        }

        nodeStack.push(root);

        while (!nodeStack.empty()) {
            TreeNode* current = nodeStack.top();
            nodeStack.pop();
            result.insert(result.begin(), current->val); // Insert at the beginning

            if (current->left) {
                nodeStack.push(current->left);
            }

            if (current->right) {
                nodeStack.push(current->right);
            }
        }

        return result;
    }
};