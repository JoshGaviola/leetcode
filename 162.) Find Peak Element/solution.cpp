class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // The peak is on the right side.
                left = mid + 1;
            } else {
                // The peak is on the left side, or mid is a peak.
                right = mid;
            }
        }

        // At this point, left and right converge to the peak element.
        return left;
    }
};
