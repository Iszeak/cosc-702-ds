package org.babcocku.linkedlist.doubly;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();

        System.out.println("--- Building the List ---");
        myList.insertLast(10);
        myList.insertLast(20);
        myList.insertLast(30);
        myList.insertFirst(5); // Insert 5 at the very beginning

        // Display current state
        System.out.print("Current List: ");
        myList.displayForward();
        // Expected Output: 5 <-> 10 <-> 20 <-> 30 <-> null

        System.out.println("\n--- Testing Deletion ---");

        // Scenario 1: Delete the middle node
        System.out.println("Deleting 20 (Middle Node)...");
        myList.delete(20);
        myList.displayForward();

        // Scenario 2: Delete the head node
        System.out.println("Deleting 5 (Head Node)...");
        myList.delete(5);
        myList.displayForward();

        // Scenario 3: Delete the last node
        System.out.println("Deleting 30 (Tail Node)...");
        myList.delete(30);
        myList.displayForward();

        System.out.println("\nFinal List contains: ");
        myList.displayForward(); // Expected Output: 10 <-> null
    }
}
