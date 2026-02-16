package org.babcocku.linkedlist.circular;

public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    // 1. Add a node to the list
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Point to itself
        } else {
            tail.next = newNode; // Old tail points to new node
            tail = newNode;      // New node becomes the tail
            tail.next = head;    // New tail points back to head
        }
    }

    // 2. Display the list
    public void display() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            } while (temp != head); // Stop when we loop back to head
            System.out.println("(Back to Head)");
        }
    }

    // 3. Delete a node
    public void delete(int key) {
        if (head == null) return;

        Node curr = head, prev = null;

        // Case 1: Deleting the only node in the list
        if (curr.data == key && curr.next == head) {
            head = null;
            tail = null;
            return;
        }

        // Case 2: Deleting the Head node
        if (curr.data == key) {
            head = head.next;
            tail.next = head;
            return;
        }

        // Case 3: Deleting a middle or tail node
        do {
            prev = curr;
            curr = curr.next;
        } while (curr != head && curr.data != key);

        if (curr.data == key) {
            prev.next = curr.next;
            if (curr == tail) {
                tail = prev; // Update tail if last node was deleted
            }
        }
    }
}
