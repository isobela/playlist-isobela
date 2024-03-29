package ui;

import javax.swing.*;
import java.awt.*;

// represents title bar for appframe.
public class TitleBar extends JPanel {
    // MODIFIES: this
    // EFFECTS: constructs title bar
    public TitleBar() {
        this.setPreferredSize(new Dimension(400,80));
        //this.setBackground(Color.red);

        JLabel titleText = new JLabel("My Playlist");
        titleText.setPreferredSize(new Dimension(200,80));
        Font font = new Font("Sans-serif",Font.BOLD, 20);
        titleText.setFont(font);
        titleText.setHorizontalAlignment(JLabel.CENTER);

        this.add(titleText);
    }
}
