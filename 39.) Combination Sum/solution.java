import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        
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
            if (candidates[i] <= remaining) {
                currentCombination.add(candidates[i]); // Include the current candidate
                dfs(candidates, remaining - candidates[i], i, currentCombination, result);
                currentCombination.remove(currentCombination.size() - 1); // Backtrack
            }
        }
    }
}
