package ua.savchenko.datastructures.linkedlist;

import ua.savchenko.List;

public class LinkedList implements List {
    Node first;
    Node last;
    int size;

    @Override
    public void add(Object element) {
        add(size, element);
    }


    @Override
    public void add(int index, Object element) {
        validateIndexToAdd(index);
        Node node = new Node(element);
        if(index == 0){
            if(size == 0){
                first = last = node;
            }else{
                first.setPrev(node);
                node.setNext(first);
                first = node;
            }
        }else if(index == size){
            last.setNext(node);
            node.setPrev(last);
            last = node;
        }else {
            Node target = find(index);
            node.setPrev(target.getPrev());
            node.setNext(target);
            target.getPrev().setNext(node);
            target.setPrev(node);
        }
        size++;
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        Node target = find(index);
        return target.getElement();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(int index) {
        validateIndex(index);
        if (index == 0) {
            if (size == 1) {
                first = null;
                last = null;
            }else {
                first = first.getNext();
                first.setPrev(null);
            }
        }else if (index == size - 1) {
            last = last.getPrev();
            last.setNext(null);
        }else {
            Node target = find(index);
            target.getPrev().setNext(target.getNext());
            target.getNext().setPrev(target.getPrev());
        }
        size--;
    }

    @Override
    public void set(int index, Object element) {
        validateIndex(index);
        Node target = find(index);
        target.setElement(element);
    }

    @Override
    public int indexOf(Object element) {
        Node target = first;
        for(int i = 0; i < size; i++){
            if(element.equals(target.getElement())){
                return i;
            }
            target = target.getNext();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        Node target = last;
        for(int i = size - 1; i >= 0; i--){
            if(element.equals(target.getElement())){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        for (Node target = first; target != null; ) {
            Node next = target.getNext();
            target.setPrev(null);
            target.setNext(null);
            target.setElement(null);
            target = next;
        }
        first = last = null;
        size = 0;
    }

    public String toString(){
        StringBuilder str = new StringBuilder("");
        Node target = first;

        for (int i = 0; i < size; i++){
            str.append(target.getElement());
            target = target.getNext();
            if(i < size - 1){
                str.append(", ");
            }
        }
        return "[" + str + "]";
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size - 1)
            System.out.println("Index " + index + " should be between 0 and " + (size - 1));
    }

    private void validateIndexToAdd(int index){
        if(index < 0 || index > size){
            System.out.println("Index " + index + " should be between 0 and " + (size));
        }
    }

    private Node find(int index){
        Node target;
        if (index < (size / 2)){
            target = first;
            for (int i = 1; i <= index; i++){
                target = target.getNext();
            }
        }else {
            target = last;
            for (int i = size - 1; i > index; i--){
                target = target.getPrev();
            }
        }

        return target;
    }


}