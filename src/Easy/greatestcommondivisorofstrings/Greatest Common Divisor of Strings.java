/**
 * @author: Ian Chen
 * @date: 1/25/2024
 */

package Easy.greatestcommondivisorofstrings;

import java.util.*;

/**
 * <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int gcd = gcd(str1.length(), str2.length());
        for (int i = gcd; i >= 1; --i) {
            if (str1.length() % i != 0 || str2.length() % i != 0) {
                continue;
            }
            String sub = str1.substring(0, i);
            if (sub.repeat(str1.length() / i).equals(str1) && sub.repeat(str2.length() / i).equals(str2)) {
                return sub;
            }
        }

        return "";
    }

    private static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}