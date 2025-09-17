/**
 * @author: Ian Chen
 * @date: 10/6/2025
 */

package Medium.houserobberii;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dpNoFirstHouse = new int[nums.length + 1];
        int[] dpNoLastHouse = new int[nums.length + 1];

        for (int i = 1; i < nums.length; i++) {
            dpNoFirstHouse[i + 1] = Math.max(dpNoFirstHouse[i],
                    dpNoFirstHouse[i - 1] + nums[i]);
        }
        for (int i = 1; i < nums.length; i++) {
            dpNoLastHouse[i + 1] = Math.max(dpNoLastHouse[i],
                    dpNoLastHouse[i - 1] + nums[i - 1]);
        }

        return Math.max(dpNoFirstHouse[nums.length], dpNoLastHouse[nums.length]);
    }
}