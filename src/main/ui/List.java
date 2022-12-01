package ui;

import model.Playlist;
import model.Song;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

// represents a playlist as a panel
public class List extends JPanel {
    private Playlist playlist = new Playlist();
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private static final String JSON_STORE = "./data/playlist.json";

    // MODIFIES: this
    // EFFECTS: constructs a layout for list to add components too
    public List() {
        GridLayout layout = new GridLayout(10,1);
        layout.setVgap(5);
        this.setLayout(layout);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

    }

    // MODIFIES: this
    // EFFECTS: removes selected component from list
    public void removeSelected() {
        for (Component c: getComponents()) {
            if (c instanceof SongInfo) {
                if (((SongInfo) c).getSelected()) {
                    this.remove(c);
                    playlist.removeSong(((SongInfo) c).getSongName());
                }
            }
            revalidate();
        }
    }

    // MODIFIES: this
    // EFFECTS: changes ranks of selected components.
    public void changeRanks(String rank) {
        for (Component c: getComponents()) {
            if (c instanceof SongInfo) {
                if (((SongInfo) c).getSelected()) {
                    SongPanel sp = new SongPanel();
                    sp.setSongPanel(((SongInfo) c).getSongName(),((SongInfo) c).getSongArtist(),
                            ((SongInfo) c).getSongGenre(), Integer.parseInt(rank));
                    SongInfo song = new SongInfo(sp);
                    int index = this.getComponentZOrder(c);
                    this.add(song, index);
                    this.remove(c);
                }
            }
        }
    }

    // EFFECTS: converts list to type playlist, and returns the playlist
    public Playlist createPlaylist() {
        playlist = new Playlist();
        for (Component c: getComponents()) {
            if (c instanceof SongInfo) {
                playlist.addSong(new Song(((SongInfo) c).getSongName(), ((SongInfo) c).getSongArtist(),
                        ((SongInfo) c).getSongGenre(), Integer.parseInt(((SongInfo) c).getSongRank())));
            }
        }
        return playlist;
    }

    // MODIFIES: this
    // EFFECTS: adds a song to song panel, from SongInfo
    public void addSongToPanel(SongInfo song) {
        Song songType = new Song(song.getSongName(), song.getSongArtist(),song.getSongGenre(),
                Integer.parseInt(song.getSongRank()));
        playlist.addSong(songType);
        this.add(song);
        new DisplayImage();
        revalidate();
    }



    // EFFECTS: saves list
    public void saveList() {
        try {
            jsonWriter.open();
            jsonWriter.write(createPlaylist());
            jsonWriter.close();
            System.out.println("Saved playlist to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: loads saved list
    public void loadList() {
        try {
            playlist = jsonReader.read();
            for (Song s: playlist.getSongs()) {
                SongPanel sp = new SongPanel();
                sp.setSongPanel(s.getName(),s.getArtist(),s.getGenre(),s.getRanking());
                SongInfo si = new SongInfo(sp);
                this.add(si);
            }
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }

    }







}
