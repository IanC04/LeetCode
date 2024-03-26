/**
 * @author: Ian Chen
 * @date: 3/26/2024
 */

package Medium.restorethearrayfromadjacentpairs;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        // Overcomplicated it seems after looking at solutions
        Set<Integer> solo = new HashSet<>();
        HashMap<Integer, Node> nodes = new HashMap<>();

        for (int[] pair : adjacentPairs) {
            int a = pair[0], b = pair[1];
            Node nA, nB;
            if (nodes.containsKey(a)) {
                nA = nodes.get(a);
                solo.remove(a);
            } else {
                solo.add(a);
                nA = new Node(a);
                nodes.put(a, nA);
            }
            if (nodes.containsKey(b)) {
                nB = nodes.get(b);
                solo.remove(b);
            } else {
                solo.add(b);
                nB = new Node(b);
                nodes.put(b, nB);
            }
            if (nA.prev == null) {
                nA.prev = nB;
            } else {
                nA.next = nB;
            }
            if (nB.prev == null) {
                nB.prev = nA;
            } else {
                nB.next = nA;
            }
        }

        int single = solo.stream().iterator().next();
        int[] result = new int[adjacentPairs.length + 1];
        result[0] = single;
        Node root = nodes.get(single);
        root.visited = true;
        dfs(root, result, 1);

        return result;
    }

    private void dfs(Node cur, int[] result, int index) {
        Node prev = cur.prev;
        if (prev != null && !prev.visited) {
            prev.visited = true;
            result[index++] = prev.val;
            dfs(prev, result, index);
        }
        Node next = cur.next;
        if (next != null && !next.visited) {
            next.visited = true;
            result[index++] = next.val;
            dfs(next, result, index);
        }
    }

    private static class Node {
        Node prev, next;
        int val;
        boolean visited;

        Node(int val) {
            this.val = val;
        }
    }
}