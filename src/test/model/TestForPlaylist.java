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
    public void testForRemoveSongInPlaylist() {
        testPlaylist.addSong(song1);
        testPlaylist.addSong(song2);
        testPlaylist.removeSong("Chateau");
        assertEquals(1, testPlaylist.getSongNames().size());
        assertEquals(song2.getName(), testPlaylist.getSongNames().get(0));
        testPlaylist.removeSong(song2.getName());
        assertEquals(0, testPlaylist.getSongNames().size());
    }

    @Test
    public void testForRemoveSongNotInPlaylist() {
        testPlaylist.addSong(song1);
        testPlaylist.removeSong(song2.getName());
        assertEquals(1, testPlaylist.getSongNames().size());
        assertEquals(song1.getName(), testPlaylist.getSongNames().get(0));


    }

    @Test
    public void testForSelectSongInPlaylist() {
        testPlaylist.addSong(song1);
        assertEquals("Chateau: Djo: Alternative: 5", testPlaylist.selectSong("Chateau"));
    }

    @Test
    public void testForSelectSongNotInPlaylist() {
        assertEquals("", testPlaylist.selectSong("Random song"));
    }


    @Test
    public void testForSelectSongAndChangeRankSongInPlaylist() {
        testPlaylist.addSong(song1);
        testPlaylist.selectSongAndChangeRank("Chateau", 4);
        assertEquals(4, song1.getRanking());
    }

    @Test
    public void testForSelectSongAndChangeRankSongNotInPlaylist() {
        testPlaylist.selectSongAndChangeRank("Oh! You Pretty Things", 0);
        assertEquals(5, song2.getRanking());
    }


}
