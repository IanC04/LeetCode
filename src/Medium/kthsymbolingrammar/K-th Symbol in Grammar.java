/*
   Written by Ian Chen
   GitHub: https://github.com/IanC04
*/

package Medium.kthsymbolingrammar;

class Solution {
    public int kthGrammar(int n, int k) {
        return Integer.bitCount(k - 1) % 2;
    }
}