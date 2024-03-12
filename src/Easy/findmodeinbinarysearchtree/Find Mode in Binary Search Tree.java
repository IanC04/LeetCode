/**
 * @author: Ian Chen
 * @date: 3/11/2024
 */

package Easy.findmodeinbinarysearchtree;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = recur(root, map);

        List<Integer> result = new ArrayList<>();
        for (int k : map.keySet()) {
            if (map.get(k) == max) {
                result.add(k);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int recur(TreeNode node, HashMap<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }

        int lMax = recur(node.left, map);
        int rMax = recur(node.right, map);
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        int cMax = map.get(node.val);

        return Math.max(Math.max(lMax, rMax), cMax);
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}