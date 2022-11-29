package ui;

import javax.swing.JOptionPane;

// represents a dialog box to change rank of song.
public class DialogBox {
    String userResponse;

    // MODIFIES: this
    // EFFECTS: constructs dialog box
    public DialogBox() {
        userResponse = JOptionPane.showInputDialog("Enter new rank");
    }


    public String getUserResponse() {
        return userResponse;
    }
}
