#include <vector>

class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (citations[mid] == n - mid) {
                // Found an h-index
                return n - mid;
            } else if (citations[mid] < n - mid) {
                // Move to the right half
                left = mid + 1;
            } else {
                // Move to the left half
                right = mid - 1;
            }
        }

        // No exact match found, return the closest h-index
        return n - left;
    }
};
