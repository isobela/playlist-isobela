package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SongInfo extends JPanel {
    private String songName;
    private String songArtist;
    private String songGenre;
    private String songRank;
    private SongPanel songPanel;
    private JButton select;
    private boolean selected;

    // MODIFIES: this
    // EFFECTS: constructs song.
    public SongInfo(SongPanel sp) {
        songPanel = sp;
        songName = songPanel.getSongName();
        songArtist = songPanel.getSongArtist();
        songGenre = songPanel.getSongGenre();
        songRank = songPanel.getSongRank();

        this.setPreferredSize(new Dimension(400,20));
        JLabel songInfo = new JLabel(this.getSongInfo());
        this.add(songInfo, BorderLayout.CENTER);

        selected = false;
        select = new JButton("Select");
        this.add(select, BorderLayout.EAST);

        selectListeners();
    }

    // EFFECTS: returns song info
    public String getSongInfo() {
        return songPanel.getSongName() + " : " + songPanel.getSongArtist() + " : " + songPanel.getSongGenre() + " : "
                + songPanel.getSongRank();
    }

    public String getSongName() {
        return songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public String getSongGenre() {
        return songGenre;
    }

    public String getSongRank() {
        return songRank;
    }

    // MODIFIES: this
    // EFFECTS: turns selected to true and changes color
    public void selectSong() {
        this.setBackground(Color.CYAN);
        selected = true;
        revalidate();
    }


    public boolean getSelected() {
        return selected;
    }

    // MODIFIES: this
    // EFFECTS: adds usage to select button
    public void selectListeners() {
        select.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectSong();
                revalidate();
            }
        });
    }




}

