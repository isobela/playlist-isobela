package ui;


import model.Playlist;
import model.Song;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Playlist Application
public class PlaylistApp {
    private Scanner scan;
    private Playlist playlist;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private static final String JSON_STORE = "./data/playlist.json";

    // EFFECTS: runs playlist application
    public PlaylistApp() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
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
        playlist = new Playlist();
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
        System.out.println("\nb-> save playlist to file");
        System.out.println("\nl -> load playlist from file");
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
        } else if (command.equals("b")) {
            savePlaylist();
        } else if (command.equals("l")) {
            loadPlaylist();
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

    // EFFECTS: saves the playlist to file
    private void savePlaylist() {
        try {
            jsonWriter.open();
            jsonWriter.write(playlist);
            jsonWriter.close();
            System.out.println("Saved playlist to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads playlist from file
    private void loadPlaylist() {
        try {
            playlist = jsonReader.read();
            System.out.println("Loaded playlist from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


}
