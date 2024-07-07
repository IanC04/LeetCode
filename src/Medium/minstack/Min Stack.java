/**
 * @author: Ian Chen
 * @date: 8/31/2024
 */

package Medium.minstack;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class MinStack {

    private static class Node {
        int val, min;

        private Node(int val) {
            this.val = val;
        }
    }

    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
        Node node = new Node(-1);
        node.min = Integer.MAX_VALUE;
        stack.push(node);
    }

    public void push(int val) {
        Node node = new Node(val);
        node.min = Math.min(val, stack.peek().min);

        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */