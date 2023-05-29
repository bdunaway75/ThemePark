import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    MyArrayList m = new MyArrayList();
    MyArrayList n = new MyArrayList(new int[]{1,2,3,4,5});

    @org.junit.jupiter.api.Test
    void getData() {
        assertArrayEquals(new int[]{1,2,3,4,5}, n.getData());
        assertArrayEquals(new int[3], m.getData()); //Test case for default init
    }

    @org.junit.jupiter.api.Test
    void add() {
        n.add(6);
        assertArrayEquals(new int[]{1,2,3,4,5,6}, n.getData()); //Adding number with filled array
        n.remove(5);
        n.remove(4);
        n.add(2);
        assertArrayEquals(new int[]{1,2,3,4,0,2}, n.getData()); //Test case for removing an array that's not full
        //Writeup doesnt state that add method should fill in gaps,
        //Just says to add to the end of the array
    }

    @org.junit.jupiter.api.Test
    void remove() {

        n.setData(new int[]{1,2,3,4,5});
        assertTrue(n.remove(3)); //Test case for index 3
        assertArrayEquals(new int[]{1,2,3,5,0}, n.getData()); //Checking if array is correct
        assertFalse(n.remove(5)); //Test case for if the index is out of bounds
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        n.setData(new int[]{1,2,3,4,5});
        assertEquals("[1, 2, 3, 4, 5]", n.toString()); //Testing string method
        n.remove(0);
        assertEquals("[2, 3, 4, 5, 0]", n.toString()); //Testing string method with remove method
    }

    @org.junit.jupiter.api.Test
    void getSize() {
        n.setData(new int[] {1,2,3,4,5});
        assertEquals(5, n.getSize());
        n.remove(4);
        assertEquals(4, n.getSize()); //Testing with removing element
        n.add(4);
        n.add(3);
        assertEquals(6, n.getSize()); //Testing with adding element

    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(m.isEmpty()); //Testing with empty constructor
        n.setData(new int[]{1,2});
        n.remove(1);
        n.remove(0);
        assertTrue(n.isEmpty()); //Test case for removing all elements
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        n.setData(new int[] {1,2,3,4,5});
        assertEquals(2, n.indexOf(3)); //Test case for finding element 3
        assertEquals(-1, n.indexOf(6)); //Test case for if the element is not in the array
    }
}