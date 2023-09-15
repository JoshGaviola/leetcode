class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0; // Empty array, no duplicates to remove
        }

        int uniqueCount = 1; // Initialize with the first element (it's always unique)
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                // Found a new unique element
                nums[uniqueCount] = nums[i];
                uniqueCount++;
            }
        }
        
        return uniqueCount;
    }
}
