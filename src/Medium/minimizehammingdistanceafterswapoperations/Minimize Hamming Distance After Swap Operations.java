/**
 * @author: Ian Chen
 * @date: 3/14/2024
 */

package Medium.minimizehammingdistanceafterswapoperations;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    private int[] parents;
    private int[] rank;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        // Idea: split arrays into subsets based on allowedSwaps using union-find
        parents = new int[source.length];
        for (int i = 0; i < parents.length; ++i) {
            parents[i] = i;
        }
        rank = new int[source.length];

        Arrays.stream(allowedSwaps).forEach(x -> union(x[0], x[1]));
        HashMap<Integer, HashMap<Integer, Integer>> sets = new HashMap<>();
        for (int i = 0; i < source.length; ++i) {
            int p = find(i);
            if (!sets.containsKey(p)) {
                sets.put(p, new HashMap<>());
            }
            HashMap<Integer, Integer> curSet = sets.get(p);
            curSet.put(source[i], curSet.getOrDefault(source[i], 0) + 1);
        }

        int diff = 0;
        for (int i = 0; i < target.length; ++i) {
            int set = find(i);
            HashMap<Integer, Integer> curMap = sets.get(set);
            if (curMap.getOrDefault(target[i], 0) > 0) {
                curMap.put(target[i], curMap.get(target[i]) - 1);
            } else {
                ++diff;
            }
        }

        return diff;
    }

    private int find(int i) {
        while (parents[i] != i) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return parents[i];
    }

    private void union(int i, int j) {
        int p1 = find(i);
        int p2 = find(j);
        if (p1 == p2) {
            return;
        }

        // If root1’s rank is less than root2’s rank
        if (rank[p1] < rank[p2]) {
            // Then move root1 under root2
            parents[p1] = p2;
            // If root1’s rank is larger than root2’s rank
        } else if (rank[p1] > rank[p2]) {
            // Then move root2 under root1
            parents[p2] = p1;
            // if ranks are the same
        } else {
            // Then move root1 under root2 (doesn't matter which one goes where)
            parents[p1] = p2;
            rank[p2]++;
        }
    }
}