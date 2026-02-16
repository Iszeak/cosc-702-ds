package org.babcocku.linkedlist.doubly;

public class DoublyLinkedList {
    Node head;

    // 1. Insert at the front (Prepend)
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
    }

    // 2. Insert at the end (Append)
    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // 3. Delete a node
    public void delete(int key) {
        Node temp = head;

        // Search for the node
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) return; // Key not found

        // If node to be deleted is head
        if (temp == head) {
            head = temp.next;
        }

        // Change next only if node to be deleted is NOT the last node
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        // Change prev only if node to be deleted is NOT the first node
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    // 4. Display Forward
    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
