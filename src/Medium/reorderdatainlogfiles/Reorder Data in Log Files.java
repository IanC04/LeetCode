/**
 * @author: Ian Chen
 * @date: 1/6/2025
 */

package Medium.reorderdatainlogfiles;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {

    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> LogComparator = (log1, log2) -> {
            boolean l1IsDigit = Character.isDigit(log1.charAt(log1.indexOf(" ") + 1));
            boolean l2IsDigit = Character.isDigit(log2.charAt(log2.indexOf(" ") + 1));
            if (l1IsDigit && l2IsDigit) {
                return 0;
            } else if (!l1IsDigit && !l2IsDigit) {
                int res = log1.substring(log1.indexOf(" ") + 1).compareTo(log2.substring(log2.indexOf(" ") + 1));
                if (res == 0) {
                    return log1.substring(0, log1.indexOf(" ")).compareTo(log2.substring(0, log2.indexOf(" ")));
                }
                return res;
            }
            return l1IsDigit ? 1 : -1;
        };
        Arrays.sort(logs, LogComparator);
        return logs;
    }
}