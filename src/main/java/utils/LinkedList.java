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

    public int remove(int value) {
        Node current = head;
        if (current.data == value) {
            int return_value = current.data;
            head = head.next;
            return return_value;
        }
        for (int i = 0; i < this.size; i++) {
            if (current.next == null) {
                return value;
            }
            if (current.next.data == value) {
                int return_value = current.next.data;
                current.next = current.next.next;
                size--;
                return return_value;
            }
            current = current.next;
        }
        return value;
    }

//    public void bubbleSort() {
//       set var swapped to false
//       for each slot in the array-1 as i:
//          for each slot in data -1 - index i
//              if value of current node is higher than the value of the next node
//                  temporary_var value is current node value
//                  current node value is the value of the next node
//                  value of the next node is the value of the temporary_var
//          if swapped is false
//              break out loop
//    }

    public void bubbleSort() {
        boolean swapped = false;
        for (int i = 0; i < size-1; i++) {
            Node current = head;
            for (int j = 0; j < size - 1 -i; j++) {
                if (current.data > current.next.data) {
                    swap(current, current.next);
                    current = current.next;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private static void swap(Node current, Node swappable) {
        int tempVar = current.data;
        current.data = swappable.data;
        swappable.data = tempVar;
    }

    /**
     *  Pseudocode for selection sort
     *  current min = min
     *  for each element 
     *      swap the index i element with the min value
     *      find min value in range of this index to the end of list
     *       
     */

    public void selectionSort() {
        Node current = head;
        for (int i = 0; i < size; i++) {
            Node minimumValueNode = minimumAt(i, size);

            swap(current, minimumValueNode);
            current = current.next;
        }
    }
    
    public Node minimumAt(int start, int end) {
        Node current = get_node(start);
        int minimum = current.data;
        for (int i = start; i < end; i++) {
            if (current.data < minimum) {
                minimum = current.data;
            }
            current = current.next;
        }
        return current;
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.remove(1);
        list.display();

    }
}


