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

    public void selectSong() {
        this.setBackground(Color.CYAN);
        selected = true;
        revalidate();
    }

    public boolean isSelected() {
        return selected;
    }

    public void selectListeners() {
        select.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectSong();
                revalidate();
            }
        });
    }

    public void setSong(String name, String artist, String genre, int rank) {

    }
}

