/*
   Written by Ian Chen
   GitHub: https://github.com/IanC04
 */

package Medium.pathsumiii;

import java.util.*;


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

class Solution {

    private long target;
    private int total = 0;
    private HashMap<Long, Integer> prefix = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        prefix.put(0L, 1);
        tryFind(root, 0L);
        return total;
    }

    private void tryFind(TreeNode node, long val) {
        if (node == null) {
            return;
        }
        val += node.val;
        total += prefix.getOrDefault((val - target), 0);
        prefix.put(val, prefix.getOrDefault(val, 0) + 1);
        tryFind(node.left, val);
        tryFind(node.right, val);
        prefix.put(val, prefix.get(val) - 1);
    }
}