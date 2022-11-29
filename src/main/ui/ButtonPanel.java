package ui;


import javax.swing.JButton;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

// represents a button panel, with an add song button, delete song button, save button and load button
public class ButtonPanel extends JPanel {
    private JButton addSong;
    private JButton deleteSong;
    private JButton changeRank;
    private JButton savePlaylist;
    private JButton loadPlaylist;
    private JButton printLog;

    Border emptyBorder = BorderFactory.createEmptyBorder();

    // MODIFIES: this
    // EFFECTS: constructs button panel
    ButtonPanel() {
        this.setPreferredSize(new Dimension(400,60));
        this.setBackground(Color.pink);
        Font font = new Font("Sans-serif",Font.PLAIN,20);
        addSong = new JButton("Add Song");

        addSong.setFont(font);
        this.add(addSong);
        deleteSong = new JButton("Delete");
  ;
        deleteSong.setFont(font);
        this.add(deleteSong);
        savePlaylist = new JButton("Save Playlist");

        savePlaylist.setFont(font);
        changeRank = new JButton("Change Rank");

        changeRank.setFont(font);
        this.add(changeRank);
        this.add(savePlaylist);
        loadPlaylist = new JButton("Load Playlist");

        loadPlaylist.setFont(font);
        this.add(loadPlaylist);
        printLog = new JButton("Print Log");

        printLog.setFont(font);
        this.add(printLog);
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

    public JButton getChangeRank() {
        return changeRank;
    }

    public JButton getPrintLog() {
        return printLog;
    }
}
