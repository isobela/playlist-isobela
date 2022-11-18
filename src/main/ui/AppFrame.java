package ui;

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
    private JButton changeRank;

    private SongPanel songPanel;
    private JButton save;
    private JButton load;
    private SongInfo song;


    // MODIFIES: this
    // EFFECTS: constructs app frame
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
        changeRank = btnPanel.getChangeRank();
        save = btnPanel.getSavePlaylist();
        load = btnPanel.getLoadPlaylist();


        addAndDelete();
        saveAndLoad();
        changeSelectedRank();

    }


    // MODIFIES: this
    // EFFECTS: adds usage to add and delete button
    public void addAndDelete() {
        addSong.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                song = new SongInfo(songPanel);
                playlist.add(song);
                new DisplayImage();
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
    }

    // MODIFIES: this
    // EFFECTS: adds usage to save and load button
    public void saveAndLoad() {
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

    // MODIFIES: this
    // EFFECTS: adds usage to change selected rank button
    public void changeSelectedRank() {
        changeRank.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                DialogBox db = new DialogBox();
                playlist.changeRanks(db.getUserResponse());
                updatePlaylist();
                revalidate();
            }
        });

    }

    // MODIFIES: this
    // EFFECTS: updates playlist in appframe
    public void updatePlaylist() {
        this.add(playlist, BorderLayout.CENTER);
    }



}
