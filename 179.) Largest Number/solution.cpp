class Solution {
public:
    string largestNumber(vector<int>& nums) {
        vector<string> numStrs;
        
        // Convert integers to strings
        for (int num : nums) {
            numStrs.push_back(to_string(num));
        }
        
        // Custom sorting function
        sort(numStrs.begin(), numStrs.end(), [](const string& a, const string& b) {
            return a + b > b + a;  // Compare as strings for maximum concatenation
        });
        
        // Handle leading zeros (e.g., [0, 0, 0])
        if (numStrs[0] == "0") {
            return "0";
        }
        
        // Concatenate sorted strings to form the largest number
        string largestNum;
        for (const string& numStr : numStrs) {
            largestNum += numStr;
        }
        
        return largestNum;
    }
};
