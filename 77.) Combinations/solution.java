import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combineHelper(result, current, n, k, 1);
        return result;
    }

    private void combineHelper(List<List<Integer>> result, List<Integer> current, int n, int k, int start) {
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            current.add(i);
            combineHelper(result, current, n, k - 1, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
