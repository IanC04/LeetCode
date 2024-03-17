/**
 * @author: Ian Chen
 * @date: 3/17/2024
 */

package Medium.implementtrieprefixtree;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class Trie {
    private static class Node {
        private final Node[] children;
        private boolean endpoint;

        Node() {
            children = new Node[26];
            endpoint = false;
        }
    }

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            boolean alreadyHas = cur.children[index] != null;
            if (!alreadyHas) {
                cur.children[index] = new Node();
            }
            cur = cur.children[index];
        }
        cur.endpoint = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            boolean alreadyHas = cur.children[index] != null;
            if (!alreadyHas) {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.endpoint;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            boolean alreadyHas = cur.children[index] != null;
            if (!alreadyHas) {
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */