package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


// represents a image to be displayed
public class DisplayImage {

    // MODIFIES: this
    // EFFECTS: constructs image
    public DisplayImage() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Display Image");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("C:\\Users\\isobel\\Downloads\\"
                            +
                            "CPSC 210 project phase 3 image.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(1);
                }

                ImageIcon imgIcon = new ImageIcon(img);
                JLabel lbl = new JLabel();
                lbl.setIcon(imgIcon);
                frame.getContentPane().add(lbl,BorderLayout.CENTER);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
    }
}

