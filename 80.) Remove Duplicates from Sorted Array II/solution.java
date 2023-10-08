class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        
        if (n <= 2) {
            return n; // No need to remove duplicates.
        }
        
        int index = 2; // Start from the third element.
        
        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }
        
        return index;
    }
}
