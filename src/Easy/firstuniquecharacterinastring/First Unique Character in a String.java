/**
 * @author: Ian Chen
 * @date: 2/4/2024
 */

package Easy.firstuniquecharacterinastring;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int firstUniqChar(String s) {
        int[] uniqueChars = new int[26];
        Arrays.fill(uniqueChars, -1);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (uniqueChars[index] == -1) {
                uniqueChars[index] = i;
            } else {
                uniqueChars[index] = -2;
            }
        }

        return Arrays.stream(uniqueChars).filter(i -> i >= 0).min().orElse(-1);
    }
}