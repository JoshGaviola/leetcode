class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> numSet;
        for (int num : nums) {
            if (numSet.count(num)) {
                return true; // If the number is already in the set, it's a duplicate.
            }
            numSet.insert(num); // Otherwise, insert it into the set.
        }
        return false; // If we've gone through the entire array without finding duplicates, return false.
    }
};
