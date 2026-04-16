package org.javacode.algorithms.basics;

public class CustomList {

    private final int DEFAULT_CAPACITY = 10;
    private int[] arr = new int[DEFAULT_CAPACITY];
    private int size = 0;

    public void add(Integer item) {
        if (size == arr.length) {
            resize();
        }

        arr[size] = item;
        size++;
    }

    public Integer get(int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public void remove(int index) {
        arr[index] = 0;
        size--;

        // shift left
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public int size() {
        return size;
    }

    private Integer calculateNextCapacity() {
        return arr.length * 2;
    }

    private void resize() {
        int newCapacity = calculateNextCapacity();
        int[] newArr = new int[newCapacity];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }
}
