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
                size++;
                return;
            }
            first.setPrev(node);
            node.setNext(first);
            first = node;
            size++;
            return;
        }

        if(index == size){
            last.setNext(node);
            node.setPrev(last);
            last = node;
            size++;
            return;
        }

        if (index < (size >> 1)) {
            Node target = first;
            for (int i = 1; i <= index; i++){
                target = target.getNext();
                if(i == index){
                    node.setPrev(target.getPrev());
                    node.setNext(target);
                    target.getPrev().setNext(node);
                    target.setPrev(node);
                }
            }
        } else {
            Node target = last;
            for (int i = size - 1; i >= index; i--){
                if(i == index){
                    node.setPrev(target.getPrev());
                    node.setNext(target);
                    target.getPrev().setNext(node);
                    target.setPrev(node);
                }
                target = target.getPrev();
            }
        }
        size++;
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        if(index < (size >> 1)){
            Node node = first;
            for(int i = 0; i < index; i++) {
                node = node.getNext();
            }
            return node.getElement();
        }else{
            Node node = last;
            for(int i = size - 1; i > index; i--) {
                node = node.getPrev();
            }
            return node.getElement();
        }
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
                size--;
                return;
            }
            first = first.getNext();
            first.setPrev(null);
            size--;
            return;
        }

        if (index == size - 1) {
            last = last.getPrev();
            last.setNext(null);
            size-- ;
            return;
        }

        if(index < (size >> 1)){
            Node target = first;
            for (int i = 1; i <= index; i++) {
                target = target.getNext();
                if (i == index) {
                    target.getPrev().setNext(target.getNext());
                    target.getNext().setPrev(target.getPrev());
                }
            }
        }else {
            Node target = last;
            for (int i = size - 1; i >= index; i--) {
                if (i == index) {
                    target.getPrev().setNext(target.getNext());
                    target.getNext().setPrev(target.getPrev());
                }
                target = target.getPrev();
            }
        }
        size--;
    }

    @Override
    public void set(int index, Object element) {
        validateIndex(index);

        if(index < (size >> 1)){
            Node node = first;
            for (int i = 0; i <= index; i ++) {
                node = node.getNext();
                if (i == index){
                    node.setElement(element);
                }
            }
        }else{
            Node node = last;
            for (int i = size - 1; i >= index; i--) {
                if (i == index){
                    node.setElement(element);
                }
                node = node.getPrev();
            }
        }
    }

    @Override
    public int indexOf(Object element) {
        for(int i = 0; i < size; i++){
            if(element.equals(get(i))){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        for(int i = size - 1; i >= 0; i--){
            if(element.equals(get(i))){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        for (Node node = first; node != null; ) {
            Node next = node.getNext();
            node.setPrev(null);
            node.setNext(null);
            node.setElement(null);
            node = next;
        }
        first = last = null;
        size = 0;
    }

    public String toString(){
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < size; i++){
            str.append(first.getElement());
            first = first.getNext();
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
}