/**
 * @author: Ian Chen
 * @date: 1/25/2024
 */

package Medium.stringcompression;

import java.util.*;

/**
 * <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int compress(char[] chars) {
        int write_index = 1;
        char charCount = 1;
        for (int index = 1; index < chars.length; ++index) {
            if (chars[index] != chars[index - 1]) {
                if (charCount != 1) {
                    String num = Integer.toString(charCount);
                    for (int i = 0; i < num.length(); i++) {
                        chars[write_index++] = num.charAt(i);
                    }
                    charCount = 1;
                }
                chars[write_index++] = chars[index];
            } else {
                ++charCount;
            }
        }
        if (charCount != 1) {
            String num = Integer.toString(charCount);
            for (int i = 0; i < num.length(); i++) {
                chars[write_index++] = num.charAt(i);
            }
        }
        return write_index;
    }
}