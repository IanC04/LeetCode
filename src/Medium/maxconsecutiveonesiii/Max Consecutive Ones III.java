/**
 * @author: Ian Chen
 * @date: 2/4/2024
 */

package Medium.maxconsecutiveonesiii;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
        }

        return right - left;
    }
}