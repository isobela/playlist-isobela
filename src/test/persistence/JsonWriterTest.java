package persistence;

import model.Playlist;
import model.Song;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Playlist pl = new Playlist();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyPlaylist() {
        try {
            Playlist pl = new Playlist();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPlaylist.json");
            writer.open();
            writer.write(pl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyPlaylist.json");
            pl = reader.read();
            assertEquals(0, pl.getSongs().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Playlist pl = new Playlist();
            pl.addSong(new Song("Good News", "Mac Miller", "Pop", 5));
            pl.addSong(new Song("Free Time", "Ruel", "Chill", 4));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralPlaylist.json");
            writer.open();
            writer.write(pl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralPlaylist.json");
            pl = reader.read();
            List<Song> songs = pl.getSongs();
            assertEquals(2, songs.size());
            checkSong("Good News", "Mac Miller", "Pop", 5, songs.get(0));
            checkSong("Free Time", "Ruel", "Chill", 4, songs.get(1));


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
