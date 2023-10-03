import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        Arrays.sort(nums); // Sort the array to group duplicates together
        
        generateUniquePermutations(nums, used, current, result);
        
        return result;
    }
    
    private void generateUniquePermutations(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue; // Skip duplicates or already used elements
            }
            
            current.add(nums[i]);
            used[i] = true;
            
            generateUniquePermutations(nums, used, current, result);
            
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
