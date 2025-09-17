/**
 * @author: Ian Chen
 * @date: 9/17/2025
 */

package Medium.stringtointegeratoi;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int myAtoi(String s) {
        int result = 0;
        boolean negative = false, numbers = false, sign = false;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    long temp = result * 10L + Character.getNumericValue(c);
                    if (negative && -temp <= Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                    if (!negative && temp >= Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    result = (int) temp;
                    numbers = true;
                    break;
                case ' ':
                    if (numbers || sign) {
                        return negative ? -result : result;
                    }
                    break;
                case '+':
                case '-':
                    if (numbers || sign) {
                        return negative ? -result : result;
                    }
                    negative = c == '-';
                    sign = true;
                    break;
                default:
                    return negative ? -result : result;
            }
        }

        return negative ? -result : result;
    }
}