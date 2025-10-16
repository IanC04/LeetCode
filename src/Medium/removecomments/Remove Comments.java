/**
 * @author: Ian Chen
 * @date: 10/15/2025
 */

package Medium.removecomments;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public List<String> removeComments(String[] source) {
        List<String> code = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        boolean inBlockComment = false;
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                boolean lineComment = line.substring(i).startsWith("//");
                boolean blockcommentStart = line.substring(i).startsWith("/*");
                boolean blockcommentEnd = line.substring(i).startsWith("*/");
                if (inBlockComment) {
                    if (blockcommentEnd) {
                        inBlockComment = false;
                        i++;
                    }
                    continue;
                }
                if (lineComment) {
                    break;
                }
                if (blockcommentStart) {
                    inBlockComment = true;
                    i++;
                    continue;
                }
                current.append(line.charAt(i));
            }
            if (!inBlockComment && !current.isEmpty()) {
                code.add(current.toString());
                current.setLength(0);
            }
        }

        return code;
    }
}