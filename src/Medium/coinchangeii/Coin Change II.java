/**
 * @author: Ian Chen
 * @date: 8/26/2024
 */

package Medium.coinchangeii;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 1; i < dp.length; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }

        return dp[amount];
    }
}