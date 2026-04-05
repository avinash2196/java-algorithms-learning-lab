package meta.medium;

import java.util.*;

public class RandomizedSet {
    private Map<Integer, Integer> map; // value -> index in list
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);  // simpler and clearer than list.add(list.size(), val)
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);

        // Swap the element with the last one and update map
        list.set(index, lastElement);
        map.put(lastElement, index);

        // Remove the last element
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
/*
            ️ Time & Space Complexity
        Operation	Time Complexity	Space Complexity
        insert()	O(1)	O(n)
        remove()	O(1)	O(n)
        getRandom()	O(1)	O(n)*/
