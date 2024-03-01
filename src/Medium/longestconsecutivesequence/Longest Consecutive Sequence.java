/**
 * @author: Ian Chen
 * @date: 2/29/2024
 */

package Medium.longestconsecutivesequence;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numberSet = (HashSet<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int max = 0;
        for (int n : nums) {
            if (numberSet.contains(n - 1)) {
                continue;
            }
            int cur = n;
            while (numberSet.contains(++cur)) {
            }
            cur -= n;
            max = Math.max(max, cur);
        }
        return max;
    }
}