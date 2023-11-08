class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int indexDiff, int valueDiff) {
        if (indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        unordered_map<long long, long long> bucket;

        for (int i = 0; i < nums.size(); ++i) {
            long long num = static_cast<long long>(nums[i]);
            long long bucketId = (num - INT_MIN) / ((long long)valueDiff + 1); // Adjust for negative numbers

            if (bucket.count(bucketId) ||
                (bucket.count(bucketId - 1) && num - bucket[bucketId - 1] <= valueDiff) ||
                (bucket.count(bucketId + 1) && bucket[bucketId + 1] - num <= valueDiff)) {
                return true;
            }

            if (bucket.size() >= indexDiff) {
                long long removedBucketId = (static_cast<long long>(nums[i - indexDiff]) - INT_MIN) / ((long long)valueDiff + 1);
                bucket.erase(removedBucketId);
            }

            bucket[bucketId] = num;
        }

        return false;
    }
};
