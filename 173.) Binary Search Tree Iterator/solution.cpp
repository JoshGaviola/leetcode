#include <stack>

class BSTIterator {
private:
    TreeNode* current;
    std::stack<TreeNode*> nodes;

public:
    BSTIterator(TreeNode* root) {
        current = root;
    }

    int next() {
        while (current != nullptr) {
            nodes.push(current);
            current = current->left;
        }
        current = nodes.top();
        nodes.pop();
        int value = current->val;
        current = current->right;
        return value;
    }

    bool hasNext() {
        return !nodes.empty() || current != nullptr;
    }
};
