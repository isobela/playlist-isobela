package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// TODO
public class AssignmentsDue {
    private List<Assignment> assignments;
    private List<String> names;




    // EFFECTS: constructs empty list of assignments not yet completed
    public AssignmentsDue() {
        this.assignments = new ArrayList<>();
        this.names = new ArrayList<>();
    }


    // REQUIRES: date in format of yyyymmdd
    // MODIFIES: this
    // EFFECTS: adds a new assignment to list of assignments
    public void addAssignment(Assignment assignment) {

        assignments.add(assignment);
        names.add(assignment.getName());
    }


    // EFFECTS: returns list of assignments in specified subject
    public List<Assignment> assignmentsDueInSubject(String subject) {
        List<Assignment> assignmentsInSubject = new ArrayList<>();
        for (Assignment a: assignments) {
            if (a.getSubject() == subject) {
                assignmentsInSubject.add(a);
            }
        }

        return assignmentsInSubject;
    }




    // MODIFIES: this
    // EFFECTS: removes completed assignments from list of assignments due
    public void removeCompletedAssignment() {
        for (Assignment a: assignments) {
            if (a.checkComplete()) {
                assignments.remove(a);
                names.remove(a.getName());
            }
        }
    }

    public List<String> getAssignmentNames() {

        return names;
    }



}




