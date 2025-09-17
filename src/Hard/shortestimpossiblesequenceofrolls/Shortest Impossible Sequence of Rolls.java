/**
 * @author: Ian Chen
 * @date: 9/17/2025
 */

package Hard.shortestimpossiblesequenceofrolls;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int sequences = 0;
        boolean[] nums = new boolean[k];
        int needed = k;
        for (int roll : rolls) {
            int n = roll - 1;
            if (!nums[n]) {
                nums[n] = true;
                needed--;
            }
            if (needed == 0) {
                sequences++;
                needed = k;
                nums = new boolean[k];
            }
        }

        return sequences + 1;
    }
}