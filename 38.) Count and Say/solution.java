class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1"; // Base case
        }
        
        String prev = countAndSay(n - 1); // Recursively get the previous term
        
        StringBuilder result = new StringBuilder();
        int count = 1;
        
        for (int i = 0; i < prev.length(); i++) {
            if (i + 1 < prev.length() && prev.charAt(i) == prev.charAt(i + 1)) {
                count++; // Count consecutive digits
            } else {
                result.append(count).append(prev.charAt(i)); // Append count and digit
                count = 1; // Reset count for the next digit
            }
        }
        
        return result.toString();
    }
}
