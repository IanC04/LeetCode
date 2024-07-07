/**
 * @author: Ian Chen
 * @date: 9/17/2024
 */

package Medium.largestnumber;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public String largestNumber(int[] nums) {
        String[] numsString = Arrays.stream(nums).mapToObj(Integer::toString).toArray(String[]::new);
        Arrays.sort(numsString, (x, y) -> (y + x).compareTo(x + y));

        StringBuilder result = new StringBuilder();
        if (numsString[0].equals("0")) {
            return "0";
        }
        for (String n : numsString) {
            result.append(n);
        }

        return result.toString();
    }
}