#include <vector>
#include <string>
#include <unordered_set>
using namespace std;

class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        vector<string> result;
        for (const string& word : words) {
            if (exist(board, word)) {
                result.push_back(word);
            }
        }
        return result;
    }

    bool exist(vector<vector<char>>& board, const string& word) {
        if (word.empty()) return false;
        
        int m = board.size();
        int n = board[0].size();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    bool dfs(vector<vector<char>>& board, int i, int j, const string& word, int k) {
        if (k == word.size()) return true;
        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size() || board[i][j] != word[k]) return false;

        char temp = board[i][j];
        board[i][j] = '#';  // Mark visited cell

        bool found = dfs(board, i + 1, j, word, k + 1) ||
                     dfs(board, i - 1, j, word, k + 1) ||
                     dfs(board, i, j + 1, word, k + 1) ||
                     dfs(board, i, j - 1, word, k + 1);

        board[i][j] = temp;  // Restore cell
        return found;
    }
};
