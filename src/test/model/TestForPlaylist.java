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
        assertEquals(2, testPlaylist.getSongNames().size());
        System.out.println(testPlaylist.getSongNames());
        testPlaylist.removeSong("Chateau");
        assertEquals(1, testPlaylist.getSongNames().size());
        System.out.println(testPlaylist.getSongNames());
        System.out.println(song2.getName());
        System.out.println(song2.getName().equals("Oh! You Pretty Things"));
        testPlaylist.removeSong(song2.getName());
        assertEquals(0, testPlaylist.getSongNames().size());
    }

    @Test
    public void testForSelectSong() {
        testPlaylist.addSong(song1);
        assertEquals("Chateau: Djo: Alternative: 5", testPlaylist.selectSong("Chateau"));
        assertEquals("", testPlaylist.selectSong("Random song"));
    }


    @Test
    public void testForSelectSongAndChangeRank() {
        assertEquals(5, song1.getRanking());
        testPlaylist.addSong(song1);
        testPlaylist.selectSongAndChangeRank("Chateau", 4);
        assertEquals(4, song1.getRanking());
        testPlaylist.selectSongAndChangeRank("Oh! You Pretty Things", 0);
        assertEquals(5, song2.getRanking());
    }


}
