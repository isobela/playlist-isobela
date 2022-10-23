package persistence;

import model.Song;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkSong(String name, String artist, String genre, int rank, Song song) {
        assertEquals(name, song.getName());
        assertEquals(artist, song.getArtist());
        assertEquals(genre, song.getGenre());
        assertEquals(rank, song.getRanking());
    }
}



