package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssignmentsDueTest {
    private AssignmentsDue testAssignmentsDue;
    private Assignment testAssignment1;
    private Assignment testAssignment2;

    @BeforeEach
    public void setup(){
        testAssignmentsDue = new AssignmentsDue();
        testAssignment1 = new Assignment("Project", "CPSC210", 20221014);
        testAssignment2 = new Assignment("Midterm", "MATH200", 20221028);
    }

    @Test
    public void testConstructor(){
        assertEquals(0, testAssignmentsDue.getAssignmentNames().size());
    }

    @Test
    public void testAddAssignment(){
        testAssignmentsDue.addAssignment(testAssignment1);
        testAssignmentsDue.addAssignment(testAssignment2);
        assertEquals(2, testAssignmentsDue.getAssignmentNames().size());
        assertTrue(testAssignmentsDue.getAssignmentNames().contains("Project"));
        assertTrue(testAssignmentsDue.getAssignmentNames().contains("Midterm"));
    }

    @Test
    public void testAssignmentsDueInSubject(){
        testAssignmentsDue.addAssignment(testAssignment1);
        testAssignmentsDue.addAssignment(testAssignment2);
        assertEquals(1, testAssignmentsDue.assignmentsDueInSubject("CPSC210").size());
        assertTrue(testAssignmentsDue.assignmentsDueInSubject("CPSC210").contains(testAssignment1));
    }


    @Test
    public void testForRemoveAssignment(){
      testAssignmentsDue.addAssignment(testAssignment1);
      testAssignmentsDue.addAssignment(testAssignment2);
      testAssignment1.markComplete();
      testAssignmentsDue.removeCompletedAssignment();
      assertEquals(1, testAssignmentsDue.getAssignmentNames().size());
      assertTrue(testAssignmentsDue.getAssignmentNames().contains("Midterm"));

    }

    @Test
    public void testForRemoveAssignmentNoneRemovedCase(){
        testAssignmentsDue.addAssignment(testAssignment1);
        testAssignmentsDue.addAssignment(testAssignment2);
        testAssignmentsDue.removeCompletedAssignment();
        assertEquals(2, testAssignmentsDue.getAssignmentNames().size());
        assertTrue(testAssignmentsDue.getAssignmentNames().contains("Midterm"));
        assertTrue(testAssignmentsDue.getAssignmentNames().contains("Project"));
    }



}
