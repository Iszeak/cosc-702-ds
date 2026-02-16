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

    public void add(T data) {
        root = addRecursive(root, data);
    }

    private Node addRecursive(Node current, T data) {
        if (current == null) {
            return new Node(data);
        }
        int cmp = data.compareTo(current.data);
        if (cmp < 0) { 
            current.left = addRecursive(current.left, data);
        } else if (cmp > 0) {
            current.right = addRecursive(current.right, data);
        }
        return current;
    }

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
