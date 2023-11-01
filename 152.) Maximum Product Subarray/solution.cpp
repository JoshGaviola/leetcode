#include <vector>
#include <algorithm>

class Solution {
public:
    int maxProduct(std::vector<int>& nums) {
        int n = nums.size();
        if (n == 0) return 0;
        
        int maxProductEndingHere = nums[0];
        int minProductEndingHere = nums[0];
        int maxProductSoFar = nums[0];
        
        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                std::swap(maxProductEndingHere, minProductEndingHere);
            }
            
            maxProductEndingHere = std::max(nums[i], maxProductEndingHere * nums[i]);
            minProductEndingHere = std::min(nums[i], minProductEndingHere * nums[i]);
            
            maxProductSoFar = std::max(maxProductSoFar, maxProductEndingHere);
        }
        
        return maxProductSoFar;
    }
};
