class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        vector<vector<int>> result;
        vector<pair<int, int>> events; // Store events (start or end of buildings)
        multiset<int> heights; // Use multiset to store building heights

        // Populate the events vector with building start and end points
        for (const auto& building : buildings) {
            events.push_back({building[0], -building[2]}); // Start of building with negative height
            events.push_back({building[1], building[2]}); // End of building with positive height
        }

        // Sort the events by x-coordinate (left endpoint)
        sort(events.begin(), events.end());

        heights.insert(0); // Initialize the set with a height of 0

        int prevMaxHeight = 0;
        
        for (const auto& event : events) {
            int x = event.first;
            int h = event.second;
            
            if (h < 0) {
                // Start of a new building
                heights.insert(-h); // Insert the height into the set
            } else {
                // End of a building
                heights.erase(heights.find(h)); // Remove the height from the set
            }
            
            int currMaxHeight = *heights.rbegin(); // Get the maximum height from the set
            
            if (currMaxHeight != prevMaxHeight) {
                // If the maximum height has changed, add a key point to the result
                result.push_back({x, currMaxHeight});
                prevMaxHeight = currMaxHeight;
            }
        }
        
        return result;
    }
};
