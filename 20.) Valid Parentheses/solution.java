class Solution {

    public boolean isValid(String s) {
        // Create a stack to store the open brackets.
        Stack<Character> stack = new Stack<>();

        // Iterate over the string.
        for (char c : s.toCharArray()) {
            // If the character is an open bracket, push it onto the stack.
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If the character is a close bracket, pop the top element from the stack.
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return false;
                }
            }
        }

        // If the stack is not empty, the string is invalid.
        return stack.isEmpty();
    }

    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}
