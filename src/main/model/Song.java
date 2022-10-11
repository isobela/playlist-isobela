package model;

// represents a song with its name, artist, genre and ranking out of five stars
public class Song {
    private String name;
    private String artist;
    private String genre;
    private int ranking;

    // REQUIRES: 0 <= ranking >= 5
    // EFFECTS: creates a song with its name, artist, genre and ranking out of five stars
    public Song(String name, String artist, String genre, int ranking) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.ranking = ranking;
    }

    // REQUIRES: 0 <= newRanking >= 5
    // MODIFIES: this
    // EFFECTS: changes previous ranking of song to newRanking
    public void changeRanking(int newRanking) {
        ranking = newRanking;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getRanking() {
        return ranking;
    }




}




