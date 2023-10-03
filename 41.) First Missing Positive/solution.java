class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Replace negative numbers and numbers greater than n with 0
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 0;
            }
        }

        // Step 2: Mark visited indices using the array itself
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > 0 && num <= n) {
                if (nums[num - 1] == 0) {
                    nums[num - 1] = -num;
                } else if (nums[num - 1] > 0) {
                    nums[num - 1] = -nums[num - 1];
                }
            }
        }

        // Step 3: Find the first positive index
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        // Step 4: If all indices are marked, return n + 1
        return n + 1;
    }
}
