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
        size++;
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    private Node get_node(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int indexOf(int value) {
        if (!isEmpty()) {
            Node current = head;
            for (int i = 0; i < this.size; i++) {
                if (current.data == value) {
                    return i;
                } else {
                    current = current.next;
                }
            }
        }
        throw new NullPointerException("Can't loop through an empty list!");
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean contains(int value) {
        if (!isEmpty()) {
            Node current = head;
            for (int i = 0; i < this.size; i++) {
                if (current.data == value) {
                    return true;
                } else {
                    current = current.next;
                }
            }
        }
        return false;
//        throw new NullPointerException("Can't loop through an empty list!");
    }

    public int set(int index, int value) {
        if (isEmpty()) {
            throw new NullPointerException("Can't loop through an empty list!");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        int old_value = current.data;
        current.data = value;

        return old_value;
    }

    public LinkedList deduplicate() {
        LinkedList new_list = new LinkedList();

        Node current = head;

        for (int i = 0; i < this.size; i++) {
            if (!new_list.contains(current.data)) {
                new_list.add(current.data);
            }
            current = current.next;
        }

        return new_list;
    }

    public void join(LinkedList other) {
        Node current = head;
        for (int i = 0; i < this.size; i++) {
            current = current.next;
            if (current.next == null) {
                current.next = other.head;
            }
        }
        size += other.size;
    }

    public LinkedList rotate(int positions) {
        int index = size - positions;

        LinkedList new_list = new LinkedList();

        Node current = this.get_node(index);
        for (int i = 0; i < positions; i++) {
            new_list.add(current.data);
            current = current.next;
        }
        current = head;
        for (int i = 0; i < index; i++) {
            new_list.add(current.data);
            current = current.next;
        }

        return new_list;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(1);

        LinkedList rotated = list.rotate(2);
        list.display();

        rotated = rotated.rotate(1);
        rotated.display();

        rotated = rotated.rotate(1);
        rotated.display();

        rotated = rotated.rotate(1);
        rotated.display();

    }
}

    // todo: deduplicate() -> should return a new list containing one instance of each value from current list
    // todo: join() -> should take in a second list and add its contents onto this list
    // todo: rotate() -> should take in the number of positions by which the list should be rotated. For example, if
    //  1 is supplied, it should take the final element from the list and move it to the start of the list

