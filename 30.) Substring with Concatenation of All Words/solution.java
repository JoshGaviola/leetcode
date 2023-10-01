import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        int sLength = s.length();

        // Create a map to store the frequency of each word in words array.
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i; // Left boundary of the sliding window
            int right = i; // Right boundary of the sliding window
            Map<String, Integer> currentWindowMap = new HashMap<>();

            while (right + wordLength <= sLength) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordFrequencyMap.containsKey(word)) {
                    currentWindowMap.put(word, currentWindowMap.getOrDefault(word, 0) + 1);

                    while (currentWindowMap.get(word) > wordFrequencyMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        left += wordLength;
                        currentWindowMap.put(leftWord, currentWindowMap.get(leftWord) - 1);
                    }

                    if (right - left == totalLength) {
                        result.add(left);
                    }
                } else {
                    // Reset the window if the current word is not in words array
                    currentWindowMap.clear();
                    left = right;
                }
            }
        }

        return result;
    }
}
