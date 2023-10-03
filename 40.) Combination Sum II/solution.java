import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        
        // Sort the candidates to handle duplicates
        Arrays.sort(candidates);
        
        // Start DFS from index 0
        dfs(candidates, target, 0, currentCombination, result);
        
        return result;
    }
    
    private void dfs(int[] candidates, int remaining, int startIndex, List<Integer> currentCombination, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(currentCombination)); // Found a valid combination
            return;
        }
        
        for (int i = startIndex; i < candidates.length; i++) {
            // Skip duplicates to avoid duplicate combinations
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            if (candidates[i] <= remaining) {
                currentCombination.add(candidates[i]); // Include the current candidate
                dfs(candidates, remaining - candidates[i], i + 1, currentCombination, result);
                currentCombination.remove(currentCombination.size() - 1); // Backtrack
            }
        }
    }
}
