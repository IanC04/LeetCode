/**
 * @author: Ian Chen
 * GitHub: https://github.com/IanC04
 */

package Easy.binarytreeinordertraversal;

import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            // Traverse left subtree
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // Add root to answer
            root = stack.pop();
            answer.add(root.val);
            // Traverse right subtree
            root = root.right;
        }
        return answer;
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
