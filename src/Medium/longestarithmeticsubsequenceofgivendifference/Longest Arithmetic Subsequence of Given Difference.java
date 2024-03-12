/**
 * @author: Ian Chen
 * @date: 3/12/2024
 */

package Medium.longestarithmeticsubsequenceofgivendifference;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 1;
        for (int num : arr) {
            int prev = num - difference;
            if (map.containsKey(prev)) {
                map.put(num, map.get(prev) + 1);
                max = Math.max(map.get(num), max);
            } else {
                map.put(num, 1);
            }
        }

        return max;
    }
}