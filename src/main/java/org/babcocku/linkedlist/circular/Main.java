package org.babcocku.linkedlist.circular;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.add(1);
        cll.add(2);
        cll.add(3);
        cll.add(4);

        System.out.println("Circular Linked List:");
        cll.display(); // Output: 1 -> 2 -> 3 -> 4 -> (Back to Head)

        System.out.println("\nDeleting node 1 (Head)...");
        cll.delete(1);
        cll.display(); // Output: 2 -> 3 -> 4 -> (Back to Head)

        System.out.println("\nDeleting node 4 (Tail)...");
        cll.delete(4);
        cll.display(); // Output: 2 -> 3 -> (Back to Head)
    }
}
