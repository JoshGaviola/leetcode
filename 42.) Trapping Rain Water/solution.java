class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0; // Cannot trap water with less than 3 bars.
        }
        
        int left = 0; // Left pointer
        int right = n - 1; // Right pointer
        int leftMax = 0; // Maximum height on the left
        int rightMax = 0; // Maximum height on the right
        int trappedWater = 0; // Total trapped water
        
        while (left < right) {
            // Update the maximum heights on the left and right
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            
            // Calculate the trapped water at the current position
            if (height[left] < height[right]) {
                trappedWater += leftMax - height[left];
                left++;
            } else {
                trappedWater += rightMax - height[right];
                right--;
            }
        }
        
        return trappedWater;
    }
}
