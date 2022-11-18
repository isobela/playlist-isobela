package ui;

import javax.swing.*;
import java.awt.*;

public class SongPanel extends JPanel {
    private JTextField songName;
    private JTextField songArtist;
    private JTextField songGenre;
    private JTextField songRank;

    // MODIFIES: this
    // EFFECTS: constructs song panel
    public SongPanel() {
        setLayout(new GridLayout(0,1));
        this.setPreferredSize(new Dimension(250,700));
        this.setBackground(Color.pink);

        songName = new JTextField();
        songArtist = new JTextField();
        songGenre = new JTextField();
        songRank = new JTextField();

        add(new JLabel("Song Name"));
        add(songName);
        add(new JLabel("Artist"));
        add(songArtist);
        add(new JLabel("Genre"));
        add(songGenre);
        add(new JLabel("Rank"));
        add(songRank);

    }

    public String getSongName() {
        return songName.getText();
    }

    public String getSongArtist() {
        return songArtist.getText();
    }

    public String getSongGenre() {
        return songGenre.getText();
    }

    public String getSongRank() {
        return songRank.getText();
    }

    // MODIFIES: this
    // EFFECTS: constructs song panel
    public void setSongPanel(String name, String artist, String genre, int rank) {
        songName = new JTextField(name);
        songArtist = new JTextField(artist);
        songGenre = new JTextField(genre);
        songRank = new JTextField(Integer.toString(rank));
    }



    
}
