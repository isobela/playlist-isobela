package ui;


import model.Playlist;
import model.Song;

import java.util.Scanner;

// Playlist Application
public class PlaylistApp {
    private Scanner scan;
    private Playlist playlist;

    // EFFECTS: runs playlist application
    public PlaylistApp() {
        runPlaylistApp();
    }



    // MODIFIES: this
    // EFFECTS: processes user input
    private void runPlaylistApp() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = scan.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: initializes playlist
    private void init() {
        playlist = new Playlist("playlist");
        scan = new Scanner(System.in);
        scan.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    public void displayMenu() {
        scan.useDelimiter("\n");
        System.out.println("\nHello, welcome to your music playlist creator! Would you like to...:");
        System.out.println("\na -> add song to playlist");
        System.out.println("\nv -> view songs in playlist");
        System.out.println("\ns -> select song");
        System.out.println("\nr -> select song and change rank");
        System.out.println("\nd -> delete song from playlist");
        System.out.println("\nq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addSongOption();
        } else if (command.equals("v")) {
            viewSongNames();
        } else if (command.equals("s")) {
            selectSongOption();
        } else if (command.equals("r")) {
            selectSongChangeRankOption();
        } else if (command.equals("d")) {
            deleteSong();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: allows user to add song to playlist
    private void addSongOption() {
        System.out.print("Enter song name:");
        String songName = scan.next();

        System.out.println("Enter artist:");
        String songArtist = scan.next();

        System.out.println("Enter genre:");
        String genre = scan.next();

        System.out.println("Rank the song out of 5 stars:");
        int rank = scan.nextInt();

        if (rank > 5 || rank < 0) {
            System.out.println("Not a valid ranking, must be between 0 and 5 stars");

        } else {

            Song addedSong = new Song(songName, songArtist, genre, rank);
            playlist.addSong(addedSong);
            System.out.println("Song added!");
        }
    }

    // MODIFIES: this
    // EFFECTS: removes song from playlist, if song name does not exist in playlist does nothing
    private void deleteSong() {
        System.out.println("Name of song you would like to delete:");
        String songName = scan.next();
        playlist.removeSong(songName);
    }

    // EFFECTS: allows user to view names of songs in playlist
    private void viewSongNames() {
        System.out.println(playlist.getSongNames());
    }

    // EFFECTS: allows user to select song and view song information in playlist
    private void selectSongOption() {
        System.out.print("Enter song name you would like to select:");
        String songName = scan.next();

        System.out.println(playlist.selectSong(songName));


    }

    // MODIFIES: this
    // EFFECTS: allows user to select song and change song ranking in playlist
    private void selectSongChangeRankOption() {
        System.out.print("Enter song name you would like to change rank of:");
        String songName = scan.next();
        System.out.print("Enter new ranking for song:");
        Integer ranking = scan.nextInt();
        playlist.selectSongAndChangeRank(songName, ranking);
        System.out.print("Rank was changed!");
    }


}
