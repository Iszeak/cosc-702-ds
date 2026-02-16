package org.babcocku.linkedlist.doublycircular;

public class DoublyCircularLinkedList {
    private Node head = null;

    // 1. Insert at the end
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            newNode.prev = head;
        } else {
            Node tail = head.prev; // In DCLL, head.prev is always the tail

            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    // 2. Display Forward
    public void displayForward() {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to Head)");
    }

    // 3. Display Backward (Proves bidirectionality)
    public void displayBackward() {
        if (head == null) return;
        Node tail = head.prev;
        Node temp = tail;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        } while (temp != tail);
        System.out.println("(Back to Tail)");
    }

    // 4. Delete a node
    public void delete(int key) {
        if (head == null) return;

        Node curr = head;
        while (curr.data != key) {
            curr = curr.next;
            if (curr == head) return; // Key not found
        }

        // If it's the only node
        if (curr.next == head && curr.prev == head) {
            head = null;
        } else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            if (curr == head) head = curr.next; // Update head if deleted
        }
    }
}
