package ua.savchenko.datastructures.linkedlist;

import org.junit.Before;
import org.junit.Test;
import ua.savchenko.List;
import ua.savchenko.datastructures.AbstractListTest;

import static org.junit.Assert.*;

public class LinkedListTest extends AbstractListTest {

    @Override
    public List getList() {
        return new LinkedList();
    }
}