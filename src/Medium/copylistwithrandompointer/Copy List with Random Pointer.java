/*
   Written by Ian Chen
   GitHub: https://github.com/IanC04
*/

package Medium.copylistwithrandompointer;

import java.util.*;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        ArrayList<Node> newNodes = new ArrayList<>();
        Node tempHead = head, newHead = null;
        HashMap<Node, Node> oldToNew = new HashMap<>();
        for (int i = 0; tempHead != null; i++) {
            newNodes.add(new Node(tempHead.val));
            if (newNodes.size() != 1) {
                newNodes.get(i - 1).next = newNodes.get(i);
            } else {
                newHead = newNodes.get(i);
            }
            oldToNew.put(tempHead, newNodes.get(i));
            tempHead = tempHead.next;
        }
        tempHead = head;
        for (int i = 0; tempHead != null; i++) {
            newNodes.get(i).random = oldToNew.getOrDefault(tempHead.random, null);
            tempHead = tempHead.next;
        }
        return newHead;
    }
}