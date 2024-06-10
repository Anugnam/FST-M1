package Activities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {
    // Test fixtures
    static ArrayList<String> list;

    // Initialize test fixtures before each test method
    @BeforeEach
    public void setUp() throws Exception {
        list = new ArrayList<String>();
        list.add("alpha"); // at index 0
        list.add("beta"); // at index 1
    }
    // Test method to test the insert operation
    @Test
    public void insert() {
        // Assertion for size
        assertEquals(2, list.size(), "Wrong size");
        // Add new element
        list.add(2, "testname");
        // Assert with new elements
        assertEquals(3, list.size(), "Wrong size");
        // Assert individual elements
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("beta", list.get(1), "Wrong element");
        assertEquals("testname", list.get(2), "Wrong element");
    }

    // Test method to test the replace operation
    @Test
    public void replace() {
        // Replace new element
        list.set(1, "testname");
        // Assert size of list
        assertEquals(2, list.size(), "Wrong size");
        // Assert individual elements
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("testname", list.get(1), "Wrong element");
    }
}
