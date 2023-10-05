import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Initialize an ArrayList to store the result.
        List<int[]> result = new ArrayList<>();
        
        // Iterate through the intervals, adding non-overlapping intervals to the result.
        int i = 0;
        int n = intervals.length;
        
        // Add intervals that end before the newInterval starts.
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // Merge overlapping intervals with the newInterval.
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        
        // Add the remaining intervals that start after the newInterval ends.
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        
        // Convert the ArrayList to an array and return.
        return result.toArray(new int[result.size()][]);
    }
}
