class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if (nums1.size() > nums2.size()) {
            return findMedianSortedArrays(nums2, nums1); 
        }
        
        int m = nums1.size();
        int n = nums2.size();
        int totalLength = m + n;
        
        int low = 0;
        int high = m;
        
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (totalLength + 1) / 2 - partitionX;
            
            int maxX = (partitionX == 0) ? INT_MIN : nums1[partitionX - 1];
            int maxY = (partitionY == 0) ? INT_MIN : nums2[partitionY - 1];
            
            int minX = (partitionX == m) ? INT_MAX : nums1[partitionX];
            int minY = (partitionY == n) ? INT_MAX : nums2[partitionY];
            
            if (maxX <= minY && maxY <= minX) {
                return calculateMedian(maxX, maxY, minX, minY, totalLength);
            } else if (maxX > minY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        
        throw std::invalid_argument("Input arrays are not sorted.");
    }
    
private:
    double calculateMedian(int maxX, int maxY, int minX, int minY, int totalLength) {
        if (totalLength % 2 == 0) {
            return static_cast<double>(max(maxX, maxY) + min(minX, minY)) / 2;
        } else {
            return static_cast<double>(maxX > maxY ? maxX : maxY);
        }
    }
};
