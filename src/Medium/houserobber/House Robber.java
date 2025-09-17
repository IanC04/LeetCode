/**
 * @author: Ian Chen
 * @date: 10/7/2025
 */

package Medium.houserobber;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int rob(int[] nums) {
        // dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        int oneBefore = 0, twoBefore = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(oneBefore, twoBefore + nums[i]);
            twoBefore = oneBefore;
            oneBefore = cur;
        }
        return oneBefore;
    }
}