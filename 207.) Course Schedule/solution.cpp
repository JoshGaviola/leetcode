class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> graph(numCourses, vector<int>());
        vector<int> visited(numCourses, 0);  // 0: unvisited, 1: visiting, 2: visited
        
        // Build the graph
        for (const vector<int>& prereq : prerequisites) {
            graph[prereq[1]].push_back(prereq[0]);
        }
        
        // Check for cycles using DFS
        for (int i = 0; i < numCourses; ++i) {
            if (!dfs(graph, visited, i)) {
                return false;  // Cycle detected, can't finish all courses
            }
        }
        
        return true;
    }
    
    bool dfs(vector<vector<int>>& graph, vector<int>& visited, int course) {
        if (visited[course] == 1) {
            return false;  // Cycle detected
        }
        if (visited[course] == 2) {
            return true;  // Already visited, no need to revisit
        }
        
        visited[course] = 1;  // Mark as visiting
        
        for (int nextCourse : graph[course]) {
            if (!dfs(graph, visited, nextCourse)) {
                return false;
            }
        }
        
        visited[course] = 2;  // Mark as visited
        return true;
    }
};
