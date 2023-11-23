// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        int left = 1, right = n;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                // If the current version is bad, search in the left half.
                right = mid;
            } else {
                // If the current version is not bad, search in the right half.
                left = mid + 1;
            }
        }
        
        // At this point, left and right converge to the first bad version.
        return left;
    }
};
