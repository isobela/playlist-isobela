package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {
    private Assignment testAssignment;

    @BeforeEach
    public void setup(){
        testAssignment = new Assignment("Quiz 5.2", "MATH 220", 2022109);
    }

    @Test
    public void testConstructor(){
        assertEquals("Quiz 5.2", testAssignment.getName());
        assertEquals("MATH 220", testAssignment.getSubject());
        assertEquals(2022109, testAssignment.getDueDate());
        assertFalse(testAssignment.checkComplete());
    }

    @Test
    public void testForMarkComplete(){
        testAssignment.markComplete();
        assertTrue(testAssignment.checkComplete());
    }

    @Test
    public void testForChangeDueDate(){
        testAssignment.changeDueDate(20221011);
        assertEquals(20221011, testAssignment.getDueDate());
    }

    @Test
    public void checkComplete(){
        assertFalse(testAssignment.checkComplete());
        testAssignment.markComplete();
        assertTrue(testAssignment.checkComplete());
    }


}