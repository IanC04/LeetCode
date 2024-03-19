/**
 * @author: Ian Chen
 * @date: 3/18/2024
 */

package Easy.findtargetindicesaftersortingarray;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int smaller = 0, amount = 0;
        for (int n : nums) {
            if (n < target) {
                ++smaller;
            } else if (n == target) {
                ++amount;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            result.add(smaller++);
        }

        return result;
    }
}