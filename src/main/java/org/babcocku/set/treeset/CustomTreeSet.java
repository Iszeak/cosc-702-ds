package org.babcocku.set.treeset;

public class CustomTreeSet<T extends Comparable<T>> {

    private class Node {
        T data;
        Node left, right;

        Node(T data) {
            this.data = data;
        }
    }

    private Node root;
    private int size = 0;

    // ADD
    public boolean add(T data) {

        if (data == null)
            throw new IllegalArgumentException("Null not allowed");

        if (root == null) {
            root = new Node(data);
            size++;
            return true;
        }

        return addRecursive(root, data);
    }

    private boolean addRecursive(Node current, T data) {

        int cmp = data.compareTo(current.data);

        if (cmp == 0)
            return false; // duplicate

        if (cmp < 0) {
            if (current.left == null) {
                current.left = new Node(data);
                size++;
                return true;
            }
            return addRecursive(current.left, data);
        }

        else {
            if (current.right == null) {
                current.right = new Node(data);
                size++;
                return true;
            }
            return addRecursive(current.right, data);
        }
    }

    // CONTAINS
    public boolean contains(T data) {
        return containsRecursive(root, data);
    }

    private boolean containsRecursive(Node current, T data) {

        if (current == null) return false;

        int cmp = data.compareTo(current.data);

        if (cmp == 0) return true;
        if (cmp < 0) return containsRecursive(current.left, data);

        return containsRecursive(current.right, data);
    }

    public int size() {
        return size;
    }

    // DISPLAY SORTED
    public void displaySorted() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }
}