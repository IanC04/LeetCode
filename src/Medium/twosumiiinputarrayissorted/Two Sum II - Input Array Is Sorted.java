/**
 * @author: Ian Chen
 * @date: 8/29/2024
 */

package Medium.twosumiiinputarrayissorted;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lp = 0, rp = numbers.length - 1;
        while (lp < rp) {
            int sum = numbers[lp] + numbers[rp];
            if (sum == target) {
                return new int[]{lp + 1, rp + 1};
            }
            if (sum > target) {
                rp--;
            } else {
                lp++;
            }
        }
        return new int[]{0, 0};
    }
}