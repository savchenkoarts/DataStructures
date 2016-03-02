package ua.savchenko.datastructures.arraylist;

import org.junit.Before;
import org.junit.Test;
import ua.savchenko.List;
import ua.savchenko.datastructures.AbstractListTest;

import static org.junit.Assert.*;

public class ArrayListTest extends AbstractListTest{


    @Override
    public List getList() {
        return new ArrayList();
    }
}