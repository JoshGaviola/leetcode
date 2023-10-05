import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals based on start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            
            // Check for overlap
            if (currentInterval[1] >= nextInterval[0]) {
                // Merge intervals by updating the end of the current interval
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // No overlap, add current interval to the result and update currentInterval
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        
        // Add the last interval to the result
        mergedIntervals.add(currentInterval);
        
        // Convert the list to an array
        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            result[i] = mergedIntervals.get(i);
        }
        
        return result;
    }
}
