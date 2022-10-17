package model;

import java.util.ArrayList;
import java.util.List;

// Represents a playlist with its songs.
public class Playlist {
    private List<Song> songs;

    // EFFECTS: constructs an empty collection of songs with their names
    public Playlist(String name) {
        songs = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds song to playlist
    // REQUIRES: no song name duplicates 
    public void addSong(Song song) {
        songs.add(song);
    }

    // MODIFIES: this
    // EFFECTS: removes song with name from playlist
    public void removeSong(String name) {
        for (Song s: songs) {
            if (s.getName().equals(name)) {
                songs.remove(s);
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

    // EFFECTS: returns names of songs in playlist
    public List<String> getSongNames() {
        List<String> songNames = new ArrayList<>();
        for (Song s: songs) {
            songNames.add(s.getName());
        }
        return songNames;
    }





}
