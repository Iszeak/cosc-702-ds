package org.babcocku.set.hashset;

public class CustomHashSet<T> {

    private static final int DEFAULT_CAPACITY = 16;

    private Node<T>[] table;
    private int size = 0;

    static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public CustomHashSet() {
        table = new Node[DEFAULT_CAPACITY];
    }

    private int index(T key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // ADD
    public boolean add(T key) {

        if (key == null)
            throw new IllegalArgumentException("Null values not supported");

        int idx = index(key);

        Node<T> current = table[idx];

        // Check duplicate
        while (current != null) {
            if (current.value.equals(key)) return false;
            current = current.next;
        }

        // Insert at bucket head
        Node<T> node = new Node<>(key);
        node.next = table[idx];
        table[idx] = node;

        size++;
        return true;
    }

    // CONTAINS
    public boolean contains(T key) {

        int idx = index(key);

        Node<T> current = table[idx];

        while (current != null) {
            if (current.value.equals(key)) return true;
            current = current.next;
        }

        return false;
    }

    // REMOVE
    public boolean remove(T key) {

        int idx = index(key);

        Node<T> current = table[idx];
        Node<T> prev = null;

        while (current != null) {

            if (current.value.equals(key)) {

                if (prev == null)
                    table[idx] = current.next;
                else
                    prev.next = current.next;

                size--;
                return true;
            }

            prev = current;
            current = current.next;
        }

        return false;
    }

    public int size() {
        return size;
    }

    // UNION
    public CustomHashSet<T> union(CustomHashSet<T> other) {

        CustomHashSet<T> result = new CustomHashSet<>();

        copyInto(result);
        other.copyInto(result);

        return result;
    }

    // INTERSECTION
    public CustomHashSet<T> intersection(CustomHashSet<T> other) {

        CustomHashSet<T> result = new CustomHashSet<>();

        forEach(value -> {
            if (other.contains(value))
                result.add(value);
        });

        return result;
    }

    // INTERNAL ITERATION (no utils)
    public void forEach(Visitor<T> visitor) {
        for (Node<T> bucket : table) {
            Node<T> current = bucket;
            while (current != null) {
                visitor.visit(current.value);
                current = current.next;
            }
        }
    }

    private void copyInto(CustomHashSet<T> target) {
        forEach(target::add);
    }

    public interface Visitor<T> {
        void visit(T value);
    }
}