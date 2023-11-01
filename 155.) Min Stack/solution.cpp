#include <stack>

class MinStack {
public:
    /** Initialize your data structure here. */
    MinStack() {
        
    }
    
    /** Push element x onto the stack. */
    void push(int val) {
        // Push the element onto the main stack.
        mainStack.push(val);

        // Update the minimum stack if needed.
        if (minStack.empty() || val <= minStack.top()) {
            minStack.push(val);
        }
    }
    
    /** Remove the top element from the stack. */
    void pop() {
        if (!mainStack.empty()) {
            // If the element being popped is the minimum, remove it from the minimum stack.
            if (mainStack.top() == minStack.top()) {
                minStack.pop();
            }
            mainStack.pop();
        }
    }
    
    /** Get the top element. */
    int top() {
        return mainStack.top();
    }
    
    /** Retrieve the minimum element in the stack. */
    int getMin() {
        return minStack.top();
    }
    
private:
    std::stack<int> mainStack;
    std::stack<int> minStack;
};
