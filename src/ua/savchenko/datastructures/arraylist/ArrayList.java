package ua.savchenko.datastructures.arraylist;

import ua.savchenko.List;

public class ArrayList implements List {
    private Object[] array;
    private int size;

    public ArrayList() {
        array = new Object[10];
        size = 0;
    }
    public int size() {
        return size;
    }

    public void add(Object element) {
        add(size(), element);
    }

    public void add(int index, Object element) {
        validateIndex(index);
        if (size() == array.length) {
            Object[] newArray = new Object[(int) (array.length * 1.5)];
            System.arraycopy(array, 0, newArray, 0, size());
            array = newArray;
        }
        for (int i = size(); i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    public void clear() {
        for(int i = 0; i < size; i++){
            array[i] = null;
        }
        size = 0;
    }

    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public Object get(int index) {
        checkIndex(index);
        return array[index];
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if ((element == null && get(i) == null) ||
                    (element != null && get(i).equals(element)))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(Object element){
        for(int i = size - 1; i >= 0; i--){
            if(element == array[i]){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public void set(int index, Object element) {
        checkIndex(index);

        array[index] = element;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        System.arraycopy(this.array, 0, array, 0, size);
        return array;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += array[i];
            if (i < size - 1)
                result += ", ";
        }
        return "[" + result + "]";
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    private void validateIndex(int index){
        if(index < 0 || index > size - 1){
            System.out.println("Index " + index + " should be between 0 and " + (size - 1));
        }
    }
}