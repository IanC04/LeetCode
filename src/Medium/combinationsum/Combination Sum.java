/**
 * @author: Ian Chen
 * @date: 9/9/2024
 */

package Medium.combinationsum;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        dfs(results, current, candidates, target, 0, 0);
        return results;
    }

    private void dfs(List<List<Integer>> results, List<Integer> current, int[] candidates,
                     int target, int index, int sum) {
        if (index == candidates.length || sum > target) {
            return;
        }
        if (sum == target) {
            results.add(new ArrayList<>(current));
            return;
        }

        current.add(candidates[index]);
        dfs(results, current, candidates, target, index, sum + candidates[index]);
        current.removeLast();
        dfs(results, current, candidates, target, index + 1, sum);
    }
}