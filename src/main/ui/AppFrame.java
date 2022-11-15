package ui;

import model.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppFrame extends JFrame {
    private TitleBar title;
    private List playlist;
    private ButtonPanel btnPanel;
    private JButton addSong;
    private JButton deleteSong;

    private SongPanel songPanel;
    private JButton save;
    private JButton load;
    private SongInfo song;


    // constructor
    public AppFrame() {
        this.setSize(400, 700);
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
        save = btnPanel.getSavePlaylist();
        load = btnPanel.getLoadPlaylist();

        addListeners();

    }


    public void addListeners() {
        addSong.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                song = new SongInfo(songPanel);
                playlist.add(song);
                revalidate();
            }
        });
        deleteSong.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                playlist.removeSelected();
                repaint();

            }
        });
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                playlist.saveList();
            }
        });
        load.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                playlist.loadList();
                updatePlaylist();
                revalidate();
            }
        });
    }

    public void updatePlaylist() {
        this.add(playlist, BorderLayout.CENTER);
    }
}