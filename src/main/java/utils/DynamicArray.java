package utils;

public class DynamicArray {
    private int [] data;
    private int size;

    public DynamicArray() {
        data = new int[16];
        size = 0;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int[] tmp = new int[data.length * 2];
            System.arraycopy(data, 0, tmp, 0, data.length);
            data = tmp;
        }
    }

    public void add(int element) {
        ensureCapacity();

        data[size] = element;
        size++;
    }

    public int get(int pos) {
        validatePosition(pos);
        return data[pos];
    }

    private void validatePosition(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
    }

    private void validatePositionForInsert(int pos) {
        if (pos < 0 || pos >= size+1) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
    }

    public int removeAtPosition(int pos) {
        validatePosition(pos);

        int deleted = data[pos];
        for (int i = pos; i < size-1; i++) {
            data[i] = data[i+1];
        }

        data[size-1] = 0;
        size--;

        return deleted;
    }

    /**
     * Returns first found position of a number specified within supplied array.
     * @param num, the number to find in an array
     * @return int index, returns the index of num in arr. Returns -1 if not found. Example:
     * Input: ([0,5,3,1], 5)
     * Output: 1
     */
    public int indexOf(int num) {
        for (int i = 0; i < data.length; i++){
            if (num == data[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int num) {
        return indexOf(num) != -1;
    }

    public void clear() {
        data = new int[data.length];
        size = 0;
    }

    public void add(int position, int value) {

        validatePositionForInsert(position);
        ensureCapacity();

        for (int i = size-1; i > position; i--) {
            data[i] = data[i-1];
        }

        size++;

    }

    public void set(int pos, int value) {
        validatePosition(pos);
        //validateNull
        data[pos] = value;
    }

    public boolean removeValue(int value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }
        removeAtPosition(index);
        return true;
    }
}
