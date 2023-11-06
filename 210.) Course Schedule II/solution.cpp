class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> adj(numCourses);
        vector<int> inDegree(numCourses, 0);
        vector<int> order;

        // Build the adjacency list and calculate in-degrees
        for (const vector<int>& prereq : prerequisites) {
            adj[prereq[1]].push_back(prereq[0]);
            inDegree[prereq[0]]++;
        }

        // Find nodes with in-degree zero and add them to a queue
        queue<int> q;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.push(i);
            }
        }

        while (!q.empty()) {
            int course = q.front();
            q.pop();
            order.push_back(course);

            for (int neighbor : adj[course]) {
                if (--inDegree[neighbor] == 0) {
                    q.push(neighbor);
                }
            }
        }

        // If all courses are included in the order, return the order; otherwise, return an empty array
        return (order.size() == numCourses) ? order : vector<int>();
    }
};
