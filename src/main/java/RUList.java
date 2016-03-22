public class RUList {

    private final int capacity;
    private final String[] values;
    private int size = 0;

    public RUList(int capacity) {
        this.capacity = capacity;
        values = new String[this.capacity];
    }

    public String get(int index) {
        return values[size - index - 1];
    }

    public void add(String value) {
        int index = indexOf(value);
        if (index == -1) {
            if (size >= capacity) {
                shiftLeftFrom(0);
                size--;
            }
            values[size] = value;
            size++;
        } else {
            shiftLeftFrom(index);
            values[size-1] = value;
        }
    }

    private void shiftLeftFrom(int index) {
        for (int j = index; j < size - 1 ; j++) {
            values[j] = values[j+1];
        }
    }

    public int indexOf(String value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(values[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
