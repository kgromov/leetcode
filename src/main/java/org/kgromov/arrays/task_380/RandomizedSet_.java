package org.kgromov.arrays.task_380;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

public class RandomizedSet_ {
    private final Set<Integer> set;
    private final Random random;

    public RandomizedSet_() {
        set = new HashSet<>();
        random = new Random();
    }

    public boolean insert(int val) {
        return this.set.add(val);
    }

    public boolean remove(int val) {
        return this.set.remove(val);
    }

    public int getRandom() {
        if (set.size() == 1) {
            return set.stream().findFirst().orElseThrow();
        }
        int index = random.nextInt(set.size());
        int i = 0;
        for (int element : this.set) {
            if (i == index) {
                return element;
            }
            i++;
        }
        throw new IllegalStateException();
    }

    public static void main(String[] args) {
        RandomizedSet_ randomizedSet = new RandomizedSet_();
        randomizedSet.insert(1);
        randomizedSet.insert(10);
        randomizedSet.insert(20);
        randomizedSet.insert(30);
        Stream.generate(randomizedSet::getRandom).limit(100).forEach(System.out::println);
    }
}
