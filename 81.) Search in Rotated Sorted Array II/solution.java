class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return true; // Found the target.
            }
            
            // Check if the left half is sorted.
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search in the left half.
                } else {
                    left = mid + 1; // Search in the right half.
                }
            } else if (nums[left] > nums[mid]) { // Check if the right half is sorted.
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Search in the right half.
                } else {
                    right = mid - 1; // Search in the left half.
                }
            } else { // nums[left] == nums[mid]
                // Handle the case where there are duplicates at the start of the array.
                left++;
            }
        }
        
        return false; // Target not found.
    }
}
