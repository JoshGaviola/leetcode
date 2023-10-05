class Solution {
    public int lengthOfLastWord(String s) {
        // Split the input string by spaces.
        String[] words = s.split(" ");
        
        // Initialize the length of the last word to 0.
        int lastWordLength = 0;
        
        // Iterate through the words and find the length of the last word.
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) { // Check for empty strings (multiple spaces).
                lastWordLength = words[i].length();
                break;
            }
        }
        
        return lastWordLength;
    }
}
