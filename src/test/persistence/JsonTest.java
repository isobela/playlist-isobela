package persistence;

import model.Song;

import static org.junit.jupiter.api.Assertions.assertEquals;

// referred to https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git for JsonTest
public class JsonTest {
    protected void checkSong(String name, String artist, String genre, int rank, Song song) {
        assertEquals(name, song.getName());
        assertEquals(artist, song.getArtist());
        assertEquals(genre, song.getGenre());
        assertEquals(rank, song.getRanking());
    }
}



