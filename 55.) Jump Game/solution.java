public class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // The maximum index you can reach
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
                // If you can't reach the current index, return false
                return false;
            }

            // Update the maximum index you can reach
            maxReach = Math.max(maxReach, i + nums[i]);

            // If you can reach the last index, return true
            if (maxReach >= n - 1) {
                return true;
            }
        }

        return true;
    }
}
