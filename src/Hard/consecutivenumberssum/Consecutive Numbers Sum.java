/**
 * @author: Ian Chen
 * @date: 8/29/2024
 */

package Hard.consecutivenumberssum;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int consecutiveNumbersSum(int n) {
        // Sum(a ...x numbers) = (a) + (a + 1) + (a + 2) = ((a) + (a + x - 1))/2 * x =
        // (2ax + x^2 - x)/2 = ax + x(x - 1)/2 = n
        // a = (n - x(x - 1)/2)/x
        int total = 0;
        for (int x = 1; x * (x - 1) / 2 < n; x++) {
            if ((n - (x * (x - 1) / 2)) % x == 0) {
                total++;
            }
        }

        return total;
    }
}