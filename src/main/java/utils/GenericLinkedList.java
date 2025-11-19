package utils;

public class GenericLinkedList<E> {
    private int size;
    private Node<E> head;

    public GenericLinkedList(){
        this.size = 0;
        this.head = null;
    }

    private static class Node<E>{
        private Node<E> next;
        private E data;

        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }

    public int size(){
        return size;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Supplied index is outside boundary of list");
        }
    }

    public boolean isEmpty() {
        return head == null;
    }


    public E get(int index){
        checkIndex(index);

        Node<E> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    public void add(E elem){
        Node<E> newNode = new Node<E>(elem);
        if(head == null){
            head = newNode;
        }else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void add(E elem, int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Supplied index is outside boundary of list");
        }

        Node<E> newNode = new Node<E>(elem);
        if(index == 0){
            newNode.next = head;
            head = newNode;
        }else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    public E remove(E value) {
        Node<E> current = head;
        if (current.data.equals(value)) {
            E return_value = current.data;
            head = head.next;
            return return_value;
        }
        for (int i = 0; i < this.size; i++) {
            if (current.next == null) {
                return value;
            }
            if (current.next.data.equals(value)) {
                E return_value = current.next.data;
                current.next = current.next.next;
                size--;
                return return_value;
            }
            current = current.next;
        }
        return value;
    }

    public E removeIndex(int index) {
        Node<E> current = head;
        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                E return_value = current.next.data;
                current.next = current.next.next;
                size--;
                return return_value;
            }
        }
        return null;
    }
}