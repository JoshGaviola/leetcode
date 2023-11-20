#include <vector>

class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        // XOR all elements to find XOR of the two unique numbers
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }

        // Find the rightmost set bit in the XOR result
        int rightmostSetBit = 1;
        while ((rightmostSetBit & xorResult) == 0) {
            rightmostSetBit <<= 1;
        }

        // Partition the array into two groups based on the rightmost set bit
        int group1 = 0, group2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                group1 ^= num;
            } else {
                group2 ^= num;
            }
        }

        return {group1, group2};
    }
};
