/**
 * @author: Ian Chen
 * @date: 12/10/2024
 */

package Medium.rottingoranges;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> bfs = new LinkedList<>();
        int time = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) bfs.add(new int[]{i, j});
            }
        }

        int count;
        while (!bfs.isEmpty()) {
            count = bfs.size();

            boolean newRotten = false;
            while (count-- > 0) {
                int[] cell = bfs.poll();
                int x = cell[0], y = cell[1];
                if (y > 0) {
                    if (grid[x][y - 1] == 1) {
                        newRotten = true;
                        grid[x][y - 1] = 2;
                        bfs.add(new int[]{x, y - 1});
                    }
                }
                if (x < grid.length - 1) {
                    if (grid[x + 1][y] == 1) {
                        newRotten = true;
                        grid[x + 1][y] = 2;
                        bfs.add(new int[]{x + 1, y});
                    }
                }
                if (y < grid[0].length - 1) {
                    if (grid[x][y + 1] == 1) {
                        newRotten = true;
                        grid[x][y + 1] = 2;
                        bfs.add(new int[]{x, y + 1});
                    }
                }
                if (x > 0) {
                    if (grid[x - 1][y] == 1) {
                        newRotten = true;
                        grid[x - 1][y] = 2;
                        bfs.add(new int[]{x - 1, y});
                    }
                }
            }
            if (newRotten) time++;
        }

        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) return -1;
            }
        }

        return time;
    }
}