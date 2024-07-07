/**
 * @author: Ian Chen
 * @date: 8/30/2024
 */

package Medium.containerwithmostwater;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int maxArea(int[] height) {
        int lp = 0, rp = height.length - 1;
        int max = 0;
        while (lp < rp) {
            int lh = height[lp], rh = height[rp];
            int cur = (rp - lp) * Math.min(lh, rh);
            max = Math.max(max, cur);
            if (lh < rh) {
                lp++;
            } else {
                rp--;
            }
        }

        return max;
    }
}