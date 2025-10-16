/**
 * @author: Ian Chen
 * @date: 10/15/2025
 */

package Medium.insertdeletegetrandomo1;

import java.util.*;

/**
 * @see <a href=https://github.com/IanC04>My GitHub</a>
 */
class RandomizedSet {

    final Map<Integer, Integer> map;
    final List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        final int valIndex = map.get(val);
        final int lastVal = list.getLast();

        map.put(lastVal, valIndex);
        list.set(valIndex, list.getLast());

        list.removeLast();
        map.remove(val);

        return true;
    }

    public int getRandom() {
        if (list.isEmpty()) {
            throw new IllegalStateException();
        }

        return list.get(new Random().nextInt(list.size()));
    }
}

/*
  Your RandomizedSet object will be instantiated and called as such:
  RandomizedSet obj = new RandomizedSet();
  boolean param_1 = obj.insert(val);
  boolean param_2 = obj.remove(val);
  int param_3 = obj.getRandom();
 */