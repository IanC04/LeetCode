/**
 * @author: Ian Chen
 * @date: 3/4/2024
 */

package Medium.kokoeatingbananas;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1;
        for (int p : piles) {
            if (p > r) {
                r = p;
            }
        }
        while (l < r) {
            int mid = (l + r) >>> 1;
            int hrsNeeded = 0;
            for (int p : piles) {
                hrsNeeded += Math.ceilDiv(p, mid);
            }
            if (hrsNeeded <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}