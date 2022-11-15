package ui;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
    private JButton addSong;
    private JButton deleteSong;
    private JButton savePlaylist;
    private JButton loadPlaylist;

    Border emptyBorder = BorderFactory.createEmptyBorder();

    //Constructor
    ButtonPanel() {
        this.setPreferredSize(new Dimension(400,60));
        this.setBackground(Color.pink);
        Font font = new Font("Sans-serif",Font.PLAIN,20);

        addSong = new JButton("Add Song");
        addSong.setBorder(emptyBorder);
        addSong.setFont(font);

        this.add(addSong);

        //this.add(Box.createHorizontalStrut(20));

        deleteSong = new JButton("Delete Song");
        deleteSong.setBorder(emptyBorder);
        deleteSong.setFont(font);

        this.add(deleteSong);

        savePlaylist = new JButton("Save Playlist");
        savePlaylist.setBorder(emptyBorder);
        savePlaylist.setFont(font);

        this.add(savePlaylist);

        loadPlaylist = new JButton("Load Playlist");
        loadPlaylist.setBorder(emptyBorder);
        loadPlaylist.setFont(font);

        this.add(loadPlaylist);


    }

    public JButton getAddSong() {
        return addSong;
    }

    public JButton getDeleteSong() {
        return deleteSong;
    }

    public JButton getSavePlaylist() {
        return savePlaylist;
    }

    public JButton getLoadPlaylist() {
        return loadPlaylist;
    }
}
