import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int count = t.length();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            if (targetMap.containsKey(rightChar)) {
                targetMap.put(rightChar, targetMap.get(rightChar) - 1);
                if (targetMap.get(rightChar) >= 0) {
                    count--;
                }
            }

            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                if (targetMap.containsKey(leftChar)) {
                    targetMap.put(leftChar, targetMap.get(leftChar) + 1);
                    if (targetMap.get(leftChar) > 0) {
                        count++;
                    }
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
