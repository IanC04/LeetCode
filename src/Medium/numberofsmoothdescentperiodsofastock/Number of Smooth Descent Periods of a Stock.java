/**
 * @author: Ian Chen
 * @date: 3/9/2024
 */

package Medium.numberofsmoothdescentperiodsofastock;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public long getDescentPeriods(int[] prices) {
        long total = 1, succ = 0;

        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] == prices[i - 1] - 1) {
                ++succ;
            } else {
                succ = 0;
            }

            total += succ + 1;
        }

        return total;
    }
}