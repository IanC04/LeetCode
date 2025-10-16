/**
 * @author: Ian Chen
 * @date: 10/15/2025
 */

package Hard.firstmissingpositive;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            // TODO Learn cyclic swaps
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}