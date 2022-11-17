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

public class List extends JPanel {
    private Playlist playlist;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private static final String JSON_STORE = "./data/playlist.json";

    public List() {
        GridLayout layout = new GridLayout(10,1);
        layout.setVgap(5);
        this.setLayout(layout);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

    }

    public void removeSelected() {
        for (Component c: getComponents()) {
            if (c instanceof SongInfo) {
                if (((SongInfo) c).isSelected()) {
                    this.remove(c);
                }
            }
            revalidate();
        }
    }

    public void changeRanks(String rank) {
        for (Component c: getComponents()) {
            if (c instanceof SongInfo) {
                if (((SongInfo) c).isSelected()) {
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
