package utils;

public class LinkedList {
    private int size;
    private Node head;
    private Node tail;

    public LinkedList() {
        this.size = 0;
    }

    private static class Node {
        private Node next;
        private int data;

        public Node(int data) {
            this.next = null;
            this.data = data;
        }
    }

    public void add(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        }
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("");
        }

        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
        }

        size++;
    }

    public int size() {
        return this.size;
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    // todo: size()
    // todo: get()
    // todo: isEmpty()
    // todo: indexOf()
    // todo: clear()
    // todo: contains()
    // todo: set()

}
