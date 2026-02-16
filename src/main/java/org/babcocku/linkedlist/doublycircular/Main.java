package org.babcocku.linkedlist.doublycircular;

public class Main {
    public static void main(String[] args) {
        DoublyCircularLinkedList dcll = new DoublyCircularLinkedList();

        dcll.insert(10);
        dcll.insert(20);
        dcll.insert(30);

        System.out.println("Forward Traversal:");
        dcll.displayForward(); // 10 <-> 20 <-> 30 <-> (Back to Head)

        System.out.println("Backward Traversal:");
        dcll.displayBackward(); // 30 <-> 20 <-> 10 <-> (Back to Tail)

        System.out.println("\nDeleting 20...");
        dcll.delete(20);
        dcll.displayForward(); // 10 <-> 30 <-> (Back to Head)
    }
}
