package org.kgromov.arrays.task_380;

import java.util.*;

public class RandomizedSet {
    private final Set<Integer> set;
    private final List<Integer> list;
    private final Random random;

    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean added = this.set.add(val);
        if (added) {
            this.list.add(val);
        }
        return added;
    }

    public boolean remove(int val) {
        boolean removed = this.set.remove(val);
        if (removed) {
            int index = this.list.indexOf(val);
            list.set(index, this.list.getLast());
            list.removeLast();
        }
        return removed;
    }

    public int getRandom() {
        if (set.size() == 1) {
            return this.list.getFirst();
        }
        int index = random.nextInt(set.size());
        return this.list.get(index);
    }
}
