import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return wordBreakHelper(s, wordSet, new ArrayList<>(), 0);
    }
    
    private List<String> wordBreakHelper(String s, Set<String> wordSet, List<String> currentList, int start) {
        List<String> result = new ArrayList<>();
        
        if (start == s.length()) {
            result.add(String.join(" ", currentList));
            return result;
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                List<String> newCurrentList = new ArrayList<>(currentList);
                newCurrentList.add(word);
                List<String> subResult = wordBreakHelper(s, wordSet, newCurrentList, end);
                result.addAll(subResult);
            }
        }
        
        return result;
    }
}
