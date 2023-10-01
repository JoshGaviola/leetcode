class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        // Find the first index i from the right such that nums[i] < nums[i+1]
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // If i is negative, it means the array is in descending order, so reverse it to get the lowest permutation.
        if (i == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        
        // Find the first index j from the right such that nums[j] > nums[i]
        int j = n - 1;
        while (nums[j] <= nums[i]) {
            j--;
        }
        
        // Swap nums[i] and nums[j]
        swap(nums, i, j);
        
        // Reverse the subarray from i+1 to the end to get the next permutation.
        reverse(nums, i + 1, n - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
