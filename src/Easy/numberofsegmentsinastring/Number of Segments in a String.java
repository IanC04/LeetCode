/*
   Written by Ian Chen
   GitHub: https://github.com/IanC04
 */

package Easy.numberofsegmentsinastring;

import java.util.*;

class Solution {
    public int countSegments(String s) {
        return s.isBlank() ? 0 : s.trim().split(" +").length;
    }
}