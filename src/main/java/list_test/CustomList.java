package list_test;

import java.util.Arrays;

public class CustomList {

    private Object elementData[];
    private int size;

    public CustomList() {
        elementData = new Object[10];
    }


    public void add(Object o) {
        ensureCapacity(size + 1);
        elementData[size++] = o;
    }

    public int getSize() {
        return size;
    }

    public void trimToSize() {
        elementData = Arrays.copyOf(elementData, size);
    }

    public void add(int index, Object o) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("index range exception was occurred");
        ensureCapacity(size + 1);

        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = o;
        size++;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("index range exception was occurred");

        return elementData[index];
    }


    public void remove(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("index range exception was occurred");
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[--size] = null;
    }

    public void ensureCapacity(int newIndex) {
        if (newIndex >= 0) {
            int factLength = elementData.length;
            if (newIndex > factLength) {
                elementData = Arrays.copyOf(elementData, size * 3 / 2 + 1);
            }
        }
    }

    @Override
    public String toString() {
        return "CustomList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }
}
