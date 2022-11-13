package ui;

import javax.swing.*;
import java.awt.*;

public class SongPanel extends JPanel {
    private JTextField songName;
    private JTextField songArtist;
    private JTextField songGenre;
    private JTextField songRank;

    public SongPanel() {
        setLayout(new GridLayout(0,1));
        this.setPreferredSize(new Dimension(250,700));
        this.setBackground(Color.pink);

        songName = new JTextField("Song name here");
        songArtist = new JTextField("Song artist here");
        songGenre = new JTextField("Song genre here");
        songRank = new JTextField("Rank this song out of 5");



        add(new JLabel("Song Name"));
        add(songName);
        add(new JLabel("Artist"));
        add(songArtist);
        add(new JLabel("Genre"));
        add(songGenre);
        add(new JLabel("Rank"));
        add(songRank);




    }
}
