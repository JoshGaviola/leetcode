#include <vector>
#include <string>

class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> result;
        int start = 0;
        int end = 0;
        int n = nums.size();

        while (end < n) {
            while (end + 1 < n && nums[end + 1] == nums[end] + 1) {
                end++;
            }
            if (start == end) {
                result.push_back(to_string(nums[start]));
            } else {
                result.push_back(to_string(nums[start]) + "->" + to_string(nums[end]));
            }
            end++;
            start = end;
        }

        return result;
    }
};
