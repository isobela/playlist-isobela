package model;
// represents an assignment having a name, subject, due date (yyyymmdd)
// and whether it is completed or not (true for completed, false otherwise)

public class Assignment {
    private String name;
    private String subject;
    private Integer date;
    private boolean isComplete;

    // EFFECTS: constructs an uncompleted assignment with its name,subject and due date
    // REQUIRES: date must be in form of yyyymmdd
    public Assignment(String name, String subject, int date) {
        this.name = name;
        this.subject = subject;
        this.date = date;
        isComplete = false;
    }

    // MODIFIES: this
    // EFFECTS: marks assignment as complete
    public void markComplete() {
        isComplete = true;
    }



    // REQUIRES: date in format of yyyymmdd
    // MODIFIES: this
    // EFFECTS: changes due date of assignment to specified date
    public void changeDueDate(int newDate) {
        date = newDate;
    }

    // EFFECTS: returns true if assignment is completed, returns false otherwise
    public boolean checkComplete() {
        return isComplete;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public int getDueDate() {
        return date;
    }

}
