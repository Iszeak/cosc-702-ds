package org.babcocku.linkedlist.singly;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);

        System.out.println("Linked List:");
        list.display(); // Output: 10 -> 20 -> 30 -> null

        list.delete(20);
        System.out.println("After deleting 20:");
        list.display(); // Output: 10 -> 30 -> null
    }
}
