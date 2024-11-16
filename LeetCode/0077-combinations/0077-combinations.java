import java.util.List;
import java.util.ArrayList;

class Solution {
    public void dfs(int start, int n, int k, List<Integer> comb, List<List<Integer>> result) {
        if (comb.size() == k) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i <= n; i++) {
            comb.add(i);
            dfs(i+1, n, k, comb, result);
            comb.remove(comb.size()-1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(1, n, k, new ArrayList<Integer>(), result);

        return result;
    }
}