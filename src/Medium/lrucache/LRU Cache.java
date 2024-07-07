/**
 * @author: Ian Chen
 * @date: 9/2/2024
 */

package Medium.lrucache;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class LRUCache {

    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>(capacity, 1.0f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */