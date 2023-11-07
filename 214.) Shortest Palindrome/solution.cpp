#include <string>
using namespace std;

class Solution {
public:
    string shortestPalindrome(string s) {
        string rev_s = s;
        reverse(rev_s.begin(), rev_s.end());
        string combined = s + "#" + rev_s;
        int n = combined.size();

        // Construct the Longest Prefix Suffix (lps) array using Manacher's algorithm
        vector<int> lps(n, 0);
        int len = 0; // Length of the longest prefix palindrome
        int i = 1;

        while (i < n) {
            if (combined[i] == combined[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        int prefix_len = lps[n - 1]; // Length of the longest prefix palindrome
        string to_add = s.substr(prefix_len); // Characters to add to make it a palindrome

        reverse(to_add.begin(), to_add.end());
        return to_add + s;
    }
};
