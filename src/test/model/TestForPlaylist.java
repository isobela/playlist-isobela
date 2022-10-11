package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestForPlaylist {
    private Playlist testPlaylist;
    private Song song1;
    private Song song2;

    @BeforeEach
    public void setup() {
        testPlaylist = new Playlist("study playlist");
        song1 = new Song("Chateau", "Djo", "Alternative", 5);
        song2 = new Song ("Oh! You Pretty Things", "David Bowie", "Pop", 5);
    }

    @Test
    public void testForConstructor() {
        assertEquals("study playlist", testPlaylist.getPlaylistName());
        assertEquals(0, testPlaylist.getSongNames().size());
    }

    @Test
    public void testForAddSong() {
        testPlaylist.addSong(song1);
        assertEquals(1, testPlaylist.getSongNames().size());
        testPlaylist.addSong(song2);
        assertEquals(2, testPlaylist.getSongNames().size());
    }

    @Test
    public void testForRemoveSong() {
        testPlaylist.addSong(song1);
        testPlaylist.addSong(song2);
        testPlaylist.removeSong(song2);
        assertEquals(1, testPlaylist.getSongNames().size());
        testPlaylist.removeSong(song1);
        assertEquals(0, testPlaylist.getSongNames().size());

    }

    @Test
    public void testForSelectSong() {
        testPlaylist.addSong(song1);
        assertEquals("Chateau: Djo: Alternative: 5", testPlaylist.selectSong(song1));
        assertEquals("", testPlaylist.selectSong(song2));
    }


    @Test
    public void testForSelectSongAndChangeRank() {
        assertEquals(5, song1.getRanking());
        testPlaylist.addSong(song1);
        testPlaylist.selectSongAndChangeRank(song1, 4);
        assertEquals(4, song1.getRanking());
        testPlaylist.selectSongAndChangeRank(song2, 0);
        assertEquals(5, song2.getRanking());
    }


}
