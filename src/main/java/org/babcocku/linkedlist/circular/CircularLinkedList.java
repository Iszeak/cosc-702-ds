package org.babcocku.linkedlist.circular;

public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void display() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            } while (temp != head);
            System.out.println("(Back to Head)");
        }
    }

    public void delete(int key) {
        if (head == null) return;

        Node curr = head, prev = null;

        if (curr.data == key && curr.next == head) {
            head = null;
            tail = null;
            return;
        }

        if (curr.data == key) {
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            prev = curr;
            curr = curr.next;
        } while (curr != head && curr.data != key);

        if (curr.data == key) {
            prev.next = curr.next;
            if (curr == tail) {
                tail = prev;
            }
        }
    }
}
