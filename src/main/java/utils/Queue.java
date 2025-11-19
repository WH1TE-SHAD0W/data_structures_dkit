package utils;

public class Queue<E> {
    private GenericLinkedList<E> queue = new GenericLinkedList<>();

    public void add(E value) {
        queue.add(E value);
    }

    public E removWe(int index) {
        return queue.removeIndex(index);
    }

    public void checkEmpty() {
        queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public E element(int index) {
        return queue.get(index);
    }
}
