/**
 * @author: Ian Chen
 * @date: 3/21/2024
 */

package Medium.removingstarsfromastring;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public String removeStars(String s) {
        // Right-to-left
        // int stars = 0;
        // StringBuilder str = new StringBuilder(s);
        // for (int i = str.length() - 1; i >= 0; --i) {
        //     if (str.charAt(i) == '*') {
        //         ++stars;
        //         str.deleteCharAt(i);
        //     } else if (stars > 0) {
        //         --stars;
        //         str.deleteCharAt(i);
        //     }
        // }
        // return str.toString();

        // Left-to-right
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                str.setLength(str.length() - 1);
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }
}