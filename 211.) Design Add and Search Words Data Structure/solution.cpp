class TrieNode {
public:
    vector<TrieNode*> children;
    bool isEnd;

    TrieNode() {
        children = vector<TrieNode*>(26, nullptr);
        isEnd = false;
    }
};

class WordDictionary {
private:
    TrieNode* root;

    bool searchTrie(TrieNode* node, string word, int index) {
        if (index == word.size()) {
            return node->isEnd;
        }
        char ch = word[index];
        if (ch != '.') {
            int childIndex = ch - 'a';
            if (node->children[childIndex] == nullptr) {
                return false;
            }
            return searchTrie(node->children[childIndex], word, index + 1);
        } else {
            for (int i = 0; i < 26; i++) {
                if (node->children[i] != nullptr && searchTrie(node->children[i], word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

public:
    WordDictionary() {
        root = new TrieNode();
    }

    void addWord(string word) {
        TrieNode* node = root;
        for (char ch : word) {
            int index = ch - 'a';
            if (node->children[index] == nullptr) {
                node->children[index] = new TrieNode();
            }
            node = node->children[index];
        }
        node->isEnd = true;
    }

    bool search(string word) {
        return searchTrie(root, word, 0);
    }
};
