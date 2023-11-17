#include <vector>
#include <cctype>

class Solution {
public:
    vector<int> diffWaysToCompute(string expression) {
        vector<int> result;

        for (int i = 0; i < expression.size(); ++i) {
            char c = expression[i];

            // If the character is an operator
            if (c == '+' || c == '-' || c == '*') {
                // Split the expression into two parts
                string left = expression.substr(0, i);
                string right = expression.substr(i + 1);

                // Compute the results for each part recursively
                vector<int> leftResults = diffWaysToCompute(left);
                vector<int> rightResults = diffWaysToCompute(right);

                // Combine the results based on the operator
                for (int leftResult : leftResults) {
                    for (int rightResult : rightResults) {
                        if (c == '+') {
                            result.push_back(leftResult + rightResult);
                        } else if (c == '-') {
                            result.push_back(leftResult - rightResult);
                        } else if (c == '*') {
                            result.push_back(leftResult * rightResult);
                        }
                    }
                }
            }
        }

        // If there are no operators in the expression (it's just a number)
        if (result.empty()) {
            result.push_back(stoi(expression));
        }

        return result;
    }
};
