/**
 * @author: Ian Chen
 * @date: 3/10/2024
 */

package Medium.exclusivetimeoffunctions;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        // Get array length... wait this is redundant
        // Went from 55% to 99% 💀
        // int max = 0;
        // for (String s : logs) {
        //     max = Math.max(max, Integer.parseInt(s.substring(0, s.indexOf(':'))));
        // }
        // int[] answer = new int[max + 1];

        int[] answer = new int[n];
        Stack<Cell> stack = new Stack<>();
        for (String s : logs) {
            int id = Integer.parseInt(s.substring(0, s.indexOf(':')));
            int time = Integer.parseInt(s.substring(s.lastIndexOf(':') + 1));
            if (s.contains("start")) {
                stack.push(new Cell(id, time));
            } else {
                Cell cur = stack.pop();
                int curTime = time - cur.start + 1 - cur.wasted;
                answer[id] += curTime;
                if (!stack.isEmpty()) {
                    stack.peek().wasted += curTime + cur.wasted;
                }
            }
        }

        return answer;
    }

    private class Cell {
        final int id;
        final int start;
        int wasted;

        private Cell(int id, int start) {
            this.id = id;
            this.start = start;
            this.wasted = 0;
        }
    }
}