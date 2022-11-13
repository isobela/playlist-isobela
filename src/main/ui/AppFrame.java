package ui;

import model.Playlist;
import model.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppFrame extends JFrame {
    private TitleBar title;
    private List playlist;
    private ButtonPanel btnPanel;
    private JButton addSong;
    private JButton deleteSong;

    private SongPanel songPanel;


    // constructor
    public AppFrame() {
        this.setSize(400,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        title = new TitleBar();
        btnPanel = new ButtonPanel();
        playlist = new List();
        songPanel = new SongPanel();




        this.add(title, BorderLayout.NORTH);
        this.add(btnPanel, BorderLayout.SOUTH);
        this.add(playlist, BorderLayout.CENTER);
        this.add(songPanel, BorderLayout.WEST);

        addSong = btnPanel.getAddSong();
        deleteSong = btnPanel.getDeleteSong();

        addListners();
    }

    public void addListners() {
        addSong.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

            }
        });
    }
}
