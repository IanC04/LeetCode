/**
 * @author: Ian Chen
 * @date: 3/3/2024
 */

package Medium.longestsubstringwithoutrepeatingcharacters;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] prev = new int[256];
        Arrays.fill(prev, -1);

        int max = 0, furthestBack = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            furthestBack = Math.max(furthestBack, prev[index] + 1);

            // Include both endpoints
            int length = i - furthestBack + 1;
            prev[index] = i;

            if (length > max) {
                max = length;
            }
        }

        return max;
    }
}