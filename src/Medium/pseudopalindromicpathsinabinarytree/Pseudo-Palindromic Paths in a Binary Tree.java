/**
 * @author: Ian Chen
 * @date: 1/23/2024
 */

package Medium.pseudopalindromicpathsinabinarytree;

import java.util.*;

/**
 * <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        // Didn't account for values being [0, 9]
        return pathHelper(root, new HashSet<>());
    }

    /**
     * Ensure each path has all even values with one or zero odd values
     *
     * @param current current node
     * @param odds    values that have appeared odd number of times
     * @return total palindromes starting from this subtree
     */
    int pathHelper(TreeNode current, HashSet<Integer> odds) {
        int nodeValue = current.val;
        boolean removed = odds.contains(nodeValue);
        if (removed) {
            odds.remove(nodeValue);
        } else {
            odds.add(nodeValue);
        }

        if (current.left == null && current.right == null) {
            int total = odds.size() <= 1 ? 1 : 0;
            if (removed) {
                odds.add(nodeValue);
            } else {
                odds.remove(nodeValue);
            }
            return total;
        }

        int leftTotal = 0, rightTotal = 0;
        if (current.left != null) {
            leftTotal = pathHelper(current.left, odds);
        }
        if (current.right != null) {
            rightTotal = pathHelper(current.right, odds);
        }
        if (removed) {
            odds.add(nodeValue);
        } else {
            odds.remove(nodeValue);
        }

        return leftTotal + rightTotal;
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
