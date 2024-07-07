/**
 * @author: Ian Chen
 * @date: 9/4/2024
 */

package Medium.evaluatereversepolishnotation;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int b = operands.pop(), a = operands.pop();
                    operands.push(a + b);
                }
                case "-" -> {
                    int b = operands.pop(), a = operands.pop();
                    operands.push(a - b);
                }
                case "*" -> {
                    int b = operands.pop(), a = operands.pop();
                    operands.push(a * b);
                }
                case "/" -> {
                    int b = operands.pop(), a = operands.pop();
                    operands.push(a / b);
                }
                default -> operands.push(Integer.parseInt(token));
            }
        }

        return operands.pop();
    }
}