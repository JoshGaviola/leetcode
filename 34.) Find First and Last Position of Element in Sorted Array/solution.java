class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        // Find the starting position
        result[0] = findStartingPosition(nums, target);
        
        // If the starting position is not found, return [-1, -1]
        if (result[0] == -1) {
            return result;
        }
        
        // Find the ending position
        result[1] = findEndingPosition(nums, target);
        
        return result;
    }
    
    private int findStartingPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int startingPos = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
            if (nums[mid] == target) {
                startingPos = mid;
            }
        }
        
        return startingPos;
    }
    
    private int findEndingPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int endingPos = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
            if (nums[mid] == target) {
                endingPos = mid;
            }
        }
        
        return endingPos;
    }
}
