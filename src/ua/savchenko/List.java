package ua.savchenko;

public interface List {
    void add(Object element);
    void add(int index, Object element);
    Object get(int index);
    int size();
    boolean isEmpty();
    void remove(int index);
    void set(int index, Object element);
    int indexOf(Object element);
    int lastIndexOf(Object value);
    void clear();
}
