#include <vector>
#include <unordered_map>

class Solution {
public:
    int maxPoints(std::vector<std::vector<int>>& points) {
        if (points.size() < 3) {
            return points.size();
        }
        
        int maxPointsOnLine = 2; // At least 2 points are needed to make a line.

        for (int i = 0; i < points.size(); i++) {
            std::unordered_map<double, int> slopeCount; // Mapping from slope to the number of points with that slope.
            int duplicates = 0; // Count of duplicate points.
            int localMax = 1; // Local maximum for the current point.
            
            for (int j = i + 1; j < points.size(); j++) {
                if (points[i] == points[j]) {
                    duplicates++;
                } else {
                    double slope = calculateSlope(points[i], points[j]);
                    slopeCount[slope]++;
                    localMax = std::max(localMax, slopeCount[slope] + 1); // Add 1 for the current point.
                }
            }
            
            maxPointsOnLine = std::max(maxPointsOnLine, localMax + duplicates);
        }
        
        return maxPointsOnLine;
    }
    
    double calculateSlope(const std::vector<int>& point1, const std::vector<int>& point2) {
        if (point1[0] == point2[0]) {
            return std::numeric_limits<double>::infinity(); // Vertical line (infinite slope).
        }
        return static_cast<double>(point2[1] - point1[1]) / (point2[0] - point1[0]);
    }
};
