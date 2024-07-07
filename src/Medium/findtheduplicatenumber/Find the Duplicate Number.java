/**
 * @author: Ian Chen
 * @date: 9/7/2024
 */

package Medium.findtheduplicatenumber;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}