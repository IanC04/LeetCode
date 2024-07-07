/**
 * @author: Ian Chen
 * @date: 7/7/2024
 */

package Medium.sortcharactersbyfrequency;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            ++freq[c];
        }
        StringBuilder sb = new StringBuilder();
        boolean hasCount = true;
        while (hasCount) {
            hasCount = false;
            char max = 0;
            int maxCnt = 0;
            for (char i = 30; i < 123; ++i) {
                if (freq[i] > maxCnt) {
                    hasCount = true;
                    maxCnt = freq[i];
                    max = i;
                }
            }
            freq[max] = 0;
            while (maxCnt-- > 0) {
                sb.append(max);
            }
        }
        return sb.toString();
    }
}