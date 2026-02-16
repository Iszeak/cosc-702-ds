package org.babcocku.set.hashset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomHashSet<T> {
    private LinkedList<T>[] buckets;
    private int capacity = 16;

    public CustomHashSet() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) buckets[i] = new LinkedList<>();
    }

    private int getIndex(T key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void add(T key) {
        int index = getIndex(key);
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }

    public boolean contains(T key) {
        return buckets[getIndex(key)].contains(key);
    }

    // Helper to get all elements (needed for iteration)
    public List<T> getAllElements() {
        List<T> all = new ArrayList<>();
        for (LinkedList<T> bucket : buckets) {
            all.addAll(bucket);
        }
        return all;
    }

    // UNION: Returns a new set containing elements from both sets
    public CustomHashSet<T> union(CustomHashSet<T> otherSet) {
        CustomHashSet<T> result = new CustomHashSet<>();

        // Add all from this set
        for (T item : this.getAllElements()) result.add(item);

        // Add all from other set (duplicates are ignored automatically)
        for (T item : otherSet.getAllElements()) result.add(item);

        return result;
    }

    // INTERSECTION: Returns a new set with common elements
    public CustomHashSet<T> intersection(CustomHashSet<T> otherSet) {
        CustomHashSet<T> result = new CustomHashSet<>();

        for (T item : this.getAllElements()) {
            if (otherSet.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
