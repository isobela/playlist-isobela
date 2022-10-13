package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestForSong {
    private Song testSong;

    @BeforeEach
    public void setup() {
        testSong = new Song("What Would I Do?",
                "Strawberry Guy", "Alternative", 3);
    }

    @Test
    public void testConstructor() {
        assertEquals("What Would I Do?", testSong.getName());
        assertEquals("Strawberry Guy", testSong.getArtist());
        assertEquals("Alternative", testSong.getGenre());
        assertEquals(3, testSong.getRanking());
    }

    @Test
    public void testChangeRanking() {
        testSong.changeRanking(4);
        assertEquals(4, testSong.getRanking());
    }
}
