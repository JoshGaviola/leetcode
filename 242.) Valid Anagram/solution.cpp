#include <unordered_map>

class Solution {
public:
    bool isAnagram(string s, string t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Use unordered_map to store the frequency of characters in string s
        unordered_map<char, int> charFrequency;

        // Update frequency for string s
        for (char c : s) {
            charFrequency[c]++;
        }

        // Check and update frequency for string t
        for (char c : t) {
            if (charFrequency.find(c) == charFrequency.end() || charFrequency[c] == 0) {
                // If the character is not in the map or its frequency is 0, not an anagram
                return false;
            }
            charFrequency[c]--;
        }

        return true;
    }
};
