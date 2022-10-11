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
    // REQUIRES: no song name duplicates
    public void addSong(Song song) {
        songs.add(song);
        names.add(song.getName());
    }

    // MODIFIES: this
    // EFFECTS: removes song with name from playlist
    public void removeSong(String name) {
        for (Song s: songs) {
            if (s.getName().equals(name)) {
                songs.remove(s);
                names.remove(s.getName());
                break;
            }
        }
    }

    // EFFECTS: selects song from name in playlist and shows information about song in format
    // Name : Artist : Genre : Ranking
    public String selectSong(String name) {
        String str = "";
        for (Song s: songs) {
            if (s.getName().equals(name)) {
                str = s.getName() + ": " + s.getArtist() + ": " + s.getGenre() + ": " + s.getRanking();
            }
        }
        return str;
    }

    // REQUIRES: 0 <= ranking >= 5
    // MODIFIES: this
    // EFFECTS: changes ranking of song
    public void selectSongAndChangeRank(String name, Integer ranking) {
        for (Song s: songs) {
            if (s.getName().equals(name)) {
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
