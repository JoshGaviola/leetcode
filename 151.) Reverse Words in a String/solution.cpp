#include <string>
#include <sstream>
#include <vector>
#include <algorithm>

class Solution {
public:
    std::string reverseWords(std::string s) {
        // Trim leading and trailing spaces.
        s = trim(s);
        
        // Split the string into words.
        std::vector<std::string> words = split(s);
        
        // Reverse the order of words.
        std::reverse(words.begin(), words.end());
        
        // Join the reversed words with a single space.
        return join(words, ' ');
    }

    std::string trim(const std::string& s) {
        size_t start = s.find_first_not_of(' ');
        size_t end = s.find_last_not_of(' ');
        if (start == std::string::npos) {
            return "";
        }
        return s.substr(start, end - start + 1);
    }

    std::vector<std::string> split(const std::string& s) {
        std::istringstream iss(s);
        std::vector<std::string> tokens;
        std::string token;
        while (std::getline(iss, token, ' ')) {
            if (!token.empty()) {
                tokens.push_back(token);
            }
        }
        return tokens;
    }

    std::string join(const std::vector<std::string>& words, char delimiter) {
        std::string result;
        for (const std::string& word : words) {
            if (!result.empty()) {
                result += delimiter;
            }
            result += word;
        }
        return result;
    }
};
