import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!part.isEmpty() && !part.equals(".")) {
                stack.push(part);
            }
        }

        StringBuilder simplifiedPath = new StringBuilder("/");
        for (String dir : stack) {
            simplifiedPath.append(dir).append("/");
        }

        // Remove the trailing slash if it exists
        if (simplifiedPath.length() > 1) {
            simplifiedPath.setLength(simplifiedPath.length() - 1);
        }

        return simplifiedPath.toString();
    }
}
