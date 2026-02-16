package org.babcocku.set.linkedhashset;

public class CustomLinkedHashSet<E> {

    private static final int DEFAULT_CAPACITY = 16;

    private Node<E>[] table;
    private int size = 0;

    private Node<E> head;
    private Node<E> tail;

    static class Node<E> {
        E key;

        // hash bucket chain
        Node<E> next;

        // insertion order links
        Node<E> before;
        Node<E> after;

        Node(E key) {
            this.key = key;
        }
    }

    @SuppressWarnings("unchecked")
    public CustomLinkedHashSet() {
        table = new Node[DEFAULT_CAPACITY];
    }

    private int index(E key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public boolean add(E key) {
        int idx = index(key);

        Node<E> current = table[idx];

        // Check duplicate
        while (current != null) {
            if (current.key.equals(key)) return false;
            current = current.next;
        }

        Node<E> node = new Node<>(key);

        // Insert into hash bucket
        node.next = table[idx];
        table[idx] = node;

        // Maintain insertion order
        if (head == null) {
            head = tail = node;
        } else {
            tail.after = node;
            node.before = tail;
            tail = node;
        }

        size++;
        return true;
    }

    public boolean contains(E key) {
        int idx = index(key);

        Node<E> current = table[idx];
        while (current != null) {
            if (current.key.equals(key)) return true;
            current = current.next;
        }

        return false;
    }

    public boolean remove(E key) {
        int idx = index(key);

        Node<E> current = table[idx];
        Node<E> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {

                // Remove from bucket
                if (prev == null) table[idx] = current.next;
                else prev.next = current.next;

                // Remove from linked order
                if (current.before != null)
                    current.before.after = current.after;
                else
                    head = current.after;

                if (current.after != null)
                    current.after.before = current.before;
                else
                    tail = current.before;

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

    public void printInOrder() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.key + " -> ");
            current = current.after;
        }
        System.out.println("null");
    }
}

