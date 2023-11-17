#include <vector>
#include <string>
#include <sstream>

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
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> paths;
        if (root == nullptr) {
            return paths;
        }
        traverse(root, "", paths);
        return paths;
    }

private:
    void traverse(TreeNode* node, string currentPath, vector<string>& paths) {
        // Add the current node value to the path
        currentPath += to_string(node->val);

        // If the current node is a leaf, add the path to the result
        if (node->left == nullptr && node->right == nullptr) {
            paths.push_back(currentPath);
            return;
        }

        // If the left child exists, traverse it
        if (node->left != nullptr) {
            traverse(node->left, currentPath + "->", paths);
        }

        // If the right child exists, traverse it
        if (node->right != nullptr) {
            traverse(node->right, currentPath + "->", paths);
        }
    }
};
