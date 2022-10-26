package persistence;

import model.Playlist;
import model.Song;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// referred to https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git for JsonReaderTest
public class JsonReaderTest extends JsonTest {
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Playlist pl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyPlaylist() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPlaylist.json");
        try {
            Playlist pl = reader.read();
            assertEquals(0, pl.getSongs().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralPlaylist() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralPlaylist.json");
        try {
            Playlist pl = reader.read();
            List<Song> songs = pl.getSongs();
            assertEquals(2, pl.getSongs().size());
            checkSong("Good News", "Mac Miller", "Pop", 5, songs.get(0));
            checkSong("Free Time", "Ruel", "Chill", 4, songs.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
