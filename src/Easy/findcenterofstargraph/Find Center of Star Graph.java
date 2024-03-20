/**
 * @author: Ian Chen
 * @date: 3/20/2024
 */

package Easy.findcenterofstargraph;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int findCenter(int[][] edges) {
        // Bad cause this is for general graph
        // int needed = edges.length;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int[] edge : edges) {
        //     int a = edge[0], b = edge[1];
        //     int ac = map.getOrDefault(a, 0) + 1, bc = map.getOrDefault(b, 0) + 1;
        //     map.put(a, ac);
        //     map.put(b, bc);
        //     if (ac == needed) {
        //         return a;
        //     }
        //     if (bc == needed) {
        //         return b;
        //     }
        // }
        //
        // return 0;

        // We are given a star graph, so the node must be in all edges
        if (edges[0][0] == edges[1][0]) {
            return edges[0][0];
        }
        if (edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }
        return edges[0][1];
    }
}