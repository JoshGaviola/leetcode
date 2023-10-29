#include <list>
#include <unordered_map>

class LRUCache {
public:
    LRUCache(int capacity) : capacity(capacity) {
    }

    int get(int key) {
        // Check if the key exists in the hash map
        auto it = cache.find(key);
        if (it != cache.end()) {
            // Move the accessed item to the front of the list (most recently used)
            items.splice(items.begin(), items, it->second);
            return it->second->second;
        }
        return -1;
    }

    void put(int key, int value) {
        // Check if the key already exists in the cache
        auto it = cache.find(key);
        if (it != cache.end()) {
            // Update the value of the existing key and move it to the front
            it->second->second = value;
            items.splice(items.begin(), items, it->second);
        } else {
            // If the cache is at its capacity, remove the least recently used item
            if (cache.size() >= capacity) {
                int leastUsedKey = items.back().first;
                cache.erase(leastUsedKey);
                items.pop_back();
            }
            // Add the new key-value pair to the cache and list
            items.emplace_front(key, value);
            cache[key] = items.begin();
        }
    }

private:
    int capacity;
    std::list<std::pair<int, int>> items; // Doubly linked list to maintain order
    std::unordered_map<int, std::list<std::pair<int, int>>::iterator> cache; // Hash map for quick access
};
