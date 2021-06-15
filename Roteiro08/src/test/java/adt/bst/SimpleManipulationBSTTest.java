package adt.bst;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleManipulationBSTTest {

    private SimpleBSTManipulationImpl<Integer> s = new SimpleBSTManipulationImpl<>();
    private BSTImpl<Integer> tree = new BSTImpl<>();
    private BSTImpl<Integer> tree2 = new BSTImpl<>();;

    private void fillTree() {
        Integer[] array = { 1, 6, 8, 9, 10, 13, 35, 76, 89 };
        Integer[] array2 = {};
        for (int i : array) {
            tree.insert(i);
        }
        for (int i : array2) {
            tree2.insert(i);
        }

    }

    @Test
    public void equals() {
        fillTree();
        // assertTrue(s.equals(tree, tree2));
    }

    @Test
    public void isSimilar() {
        fillTree();
        // assertFalse(s.isSimilar(tree, tree2));
        //assertTrue(s.isSimilar(tree, tree2));
    }

    @Test
    public void orderStatistics() {
        fillTree();

        assertEquals(s.orderStatistic(tree, 3), new Integer(8));
        assertEquals(s.orderStatistic(tree, 1), new Integer(1));
        assertEquals(s.orderStatistic(tree, 5), new Integer(10));
        assertEquals(s.orderStatistic(tree, 2), new Integer(6));

        assertEquals(s.orderStatistic(tree, 9), new Integer(89));
        assertEquals(s.orderStatistic(tree, 10), null);
    }

}