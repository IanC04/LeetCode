/*
   Written by Ian Chen
   GitHub: https://github.com/IanC04
*/

package Easy.poweroffour;

class Solution {
    public boolean isPowerOfFour(int n) {
        return Integer.bitCount(n) == 1 && (n & 0x55_55_55_55) != 0;
    }
}