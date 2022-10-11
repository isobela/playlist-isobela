package model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private List<Song> songs;
    private List<String> names;

    // EFFECTS: constructs an empty collection of songs with name
    public Playlist(String name) {
        this.name = name;
        songs = new ArrayList<>();
        names = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds song to playlist
    public void addSong(Song song) {
        songs.add(song);
        names.add(song.getName());
    }

    // MODIFIES: this
    // EFFECTS: removes song
    public void removeSong(Song song) {
        songs.remove(song);
        names.remove(song.getName());
    }

    // EFFECTS: selects song in playlist and shows information about song in format
    // Name : Artist : Genre : Ranking
    public String selectSong(Song song) {
        String str = "";
        for (Song s: songs) {
            if (s == song) {
                str = s.getName() + ": " + s.getArtist() + ": " + s.getGenre() + ": " + s.getRanking();
            }
        }
        return str;
    }

    // REQUIRES: 0 <= ranking >= 5
    // MODIFIES: this
    // EFFECTS: changes ranking of song
    public void selectSongAndChangeRank(Song song, Integer ranking) {
        for (Song s: songs) {
            if (s == song) {
                s.changeRanking(ranking);
            }
        }
    }


    public List<String> getSongNames() {
        return names;
    }

    public String getPlaylistName() {
        return name;
    }



}
