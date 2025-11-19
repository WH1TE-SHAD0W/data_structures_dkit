package utils;

public class BoundedQueue extends Queue{
    private static final int DEFAULT_MAX = 100;
    private int capacity;

    public BoundedQueue() {
        super();
        capacity = DEFAULT_MAX;
    }

    public BoundedQueue(int maxSize) {
        super();
        capacity = maxSize;
    }

    @Override
    public void add(Object value) {
        checkFull();
        super.add(value);
    }

    public void checkFull() {
        if (!(size() < capacity)) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void setBoundedSize(int bound) {
        capacity = bound;
    }
}
