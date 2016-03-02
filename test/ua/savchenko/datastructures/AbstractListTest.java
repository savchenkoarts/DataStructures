package ua.savchenko.datastructures;

import org.junit.Test;
import ua.savchenko.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class AbstractListTest {

    private List list = getList();


    @Test
    public void testAdd() {
        list.add(50);
        assertTrue(list.size() == 1);
    }

    @Test
    public void testAddIndex(){
        list.add(0, 10);
        list.add(1, 20);
        list.add(1, 30);
        assertEquals(list.get(0), 10);
        assertEquals(list.get(1), 30);
        assertEquals(list.get(2), 20);
        assertTrue(list.size() == 3);
    }

    @Test
    public void testGet() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(list.get(0), 10);
        assertEquals(list.get(1), 20);
        assertEquals(list.get(2), 30);
    }

    @Test
    public void testRemoveElementFromArray() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertTrue(!list.isEmpty());
        list.remove(1);
        assertEquals(list.get(0), 10);
        assertEquals(list.get(1), 30);
        assertTrue(list.size() == 2);

        list.remove(1);
        assertEquals(list.get(0), 10);
        assertTrue(list.size() == 1);

        list.remove(0);
        assertTrue(list.size() == 0);
    }

    @Test
    public void testSet(){
        list.add(5);
        list.add(7);
        list.add(4);
        assertEquals(7, list.get(1));
        list.set(1, 9);
        assertEquals(9, list.get(1));
    }

    @Test
    public void testIndexOf(){
        list.add(2);
        list.add(7);
        list.add(7);
        assertEquals(1, list.indexOf(7));
    }

    @Test
    public void testLastIndexOf(){
        list.add(2);
        list.add(7);
        list.add(7);
        assertEquals(2, list.lastIndexOf(7));
    }

    @Test
    public void testIsEmpty(){
        list.add(2);
        list.add(7);
        assertEquals(2, list.get(0));
        assertEquals(7, list.get(1));
        assertTrue(!list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testClear() {
        list.add(5);
        list.add(7);
        list.add(4);

        assertTrue(list.size() == 3);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testToString() {
        String expected = "[10, 20, 30]";
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals (expected, list.toString());
    }

     public abstract List getList();
}
