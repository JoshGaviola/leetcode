class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_set<int> seen; // Set to store the last k elements
        for (int i = 0; i < nums.size(); ++i) {
            if (i > k) {
                // If the size of the set exceeds k, remove the oldest element
                seen.erase(nums[i - k - 1]);
            }
            if (seen.find(nums[i]) != seen.end()) {
                // If the current element is already in the set, return true
                return true;
            }
            seen.insert(nums[i]); // Add the current element to the set
        }
        return false; // No duplicates found
    }
};
