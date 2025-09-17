/**
 * @author: Ian Chen
 * @date: 10/7/2025
 */

package Medium.stepbystepdirectionsfromabinarytreenodetoanother;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder toStart = new StringBuilder();
        StringBuilder toEnd = new StringBuilder();
        getDirections(root, startValue, toStart);
        getDirections(root, destValue, toEnd);
        toStart.reverse();
        toEnd.reverse();
        int i = 0;
        while (i < toStart.length() && i < toEnd.length()) {
            if (toStart.charAt(i) != toEnd.charAt(i)) {
                break;
            }
            i++;
        }
        return "U".repeat(toStart.length() - i) + toEnd.substring(i);
    }

    private boolean getDirections(TreeNode t, int value, StringBuilder cur) {
        if (t == null) {
            return false;
        }
        if (t.val == value) {
            return true;
        }
        boolean left = getDirections(t.left, value, cur);
        if (left) {
            cur.append('L');
            return true;
        }
        boolean right = getDirections(t.right, value, cur);
        if (right) {
            cur.append('R');
            return true;
        }
        return false;
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