/**
 * @author: Ian Chen
 * @date: 1/25/2024
 */

package Easy.mergestringsalternately;

import java.util.*;

/**
 * <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0, j = 0; i < word1.length() || j < word2.length(); ++i, ++j) {
            if (i < word1.length())
                answer.append(word1.charAt(i));
            if (j < word2.length())
                answer.append(word2.charAt(j));
        }
        return answer.toString();
    }
}