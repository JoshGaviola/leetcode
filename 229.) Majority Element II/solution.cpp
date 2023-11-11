class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;

        // Phase 1: Identify potential candidates
        for (int num : nums) {
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
            else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // Phase 2: Count occurrences of potential candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
        }

        vector<int> result;
        if (count1 > nums.size() / 3)
            result.push_back(candidate1);
        if (count2 > nums.size() / 3)
            result.push_back(candidate2);

        return result;
    }
};
