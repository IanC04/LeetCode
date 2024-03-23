/**
 * @author: Ian Chen
 * @date: 3/23/2024
 */

package Medium.findthelongestsemirepetitivesubstring;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int prevRep = 0;
        int curRep = 0;
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                prevRep = curRep;
                curRep = i;
            }
            max = Math.max(max, i - prevRep + 1);
        }

        return max;
    }
}