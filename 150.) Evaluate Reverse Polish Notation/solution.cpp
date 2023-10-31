#include <vector>
#include <string>
#include <stack>

class Solution {
public:
    int evalRPN(std::vector<std::string>& tokens) {
        std::stack<int> stack;

        for (const std::string& token : tokens) {
            if (isOperator(token)) {
                int operand2 = stack.top();
                stack.pop();
                int operand1 = stack.top();
                stack.pop();

                if (token == "+") {
                    stack.push(operand1 + operand2);
                } else if (token == "-") {
                    stack.push(operand1 - operand2);
                } else if (token == "*") {
                    stack.push(operand1 * operand2);
                } else if (token == "/") {
                    stack.push(operand1 / operand2);
                }
            } else {
                stack.push(std::stoi(token));
            }
        }

        return stack.top();
    }

    bool isOperator(const std::string& token) {
        return (token == "+" || token == "-" || token == "*" || token == "/");
    }
};
