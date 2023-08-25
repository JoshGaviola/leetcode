import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0; // Left pointer of the sliding window
        HashSet<Character> seen = new HashSet<>(); // Set to keep track of seen characters
        
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            while (seen.contains(currentChar)) {
                char leftChar = s.charAt(left);
                seen.remove(leftChar);
                left++; // Move the left pointer to exclude the repeating character
            }
            
            seen.add(currentChar); // Add the current character to the set
            maxLength = Math.max(maxLength, right - left + 1); // Update the maximum length
        }
        
        return maxLength;
    }
}
