import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // End word is not in the word list, so transformation is not possible.
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int transformations = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] chars = word.toCharArray();
                for (int j = 0; j < word.length(); j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (newWord.equals(endWord)) {
                            return transformations + 1;
                        }
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    chars[j] = originalChar;
                }
            }
            transformations++;
        }

        return 0; // No transformation sequence found.
    }
}
