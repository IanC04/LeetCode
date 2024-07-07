/**
 * @author: Ian Chen
 * @date: 9/7/2024
 */

package Medium.generateparentheses;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] current = new char[n * 2];

        dfs(result, current, n, 0, 0);
        return result;
    }

    private void dfs(List<String> result, char[] current, int lp, int index, int rp) {
        if (lp == 0 && rp == 0) {
            result.add(new String(current));
            return;
        }

        if (lp > 0) {
            current[index] = '(';
            dfs(result, current, lp - 1, index + 1, rp + 1);
        }
        if (rp > 0) {
            current[index] = ')';
            dfs(result, current, lp, index + 1, rp - 1);
        }
    }
}