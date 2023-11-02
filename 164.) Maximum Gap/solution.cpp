class Solution {
public:
    int maximumGap(vector<int>& nums) {
        int n = nums.size();

        if (n < 2)
            return 0;

        int maxVal = *max_element(nums.begin(), nums.end());
        int minVal = *min_element(nums.begin(), nums.end());

        int bucketSize = max(1, (maxVal - minVal) / (n - 1));
        int bucketCount = (maxVal - minVal) / bucketSize + 1;

        vector<int> maxBucket(bucketCount, INT_MIN);
        vector<int> minBucket(bucketCount, INT_MAX);

        for (int num : nums) {
            int index = (num - minVal) / bucketSize;
            maxBucket[index] = max(maxBucket[index], num);
            minBucket[index] = min(minBucket[index], num);
        }

        int maxGap = 0;
        int prevMax = minVal;
        for (int i = 0; i < bucketCount; i++) {
            if (minBucket[i] == INT_MAX)
                continue;
            maxGap = max(maxGap, minBucket[i] - prevMax);
            prevMax = maxBucket[i];
        }

        return maxGap;
    }
};
