# CPSC 210 Term Project

## Music Playlist Creator

For my term project I will create a music playlist creator intended for users
to create and save a playlist. Users will be able to add songs to a playlist
and retrieve information about individual songs and rank them on scale out of five.
The music playlist creator will save users song rankings for future
reference to help users track which songs they like and dislike. The music playlist
creator is intended for anyone who enjoys music and who may want to keep
track of their favourite songs. I chose to create this 
Music Playlist Creator because I am constantly listening to music and I would love a way
to sort and rank the songs im listening too!

## User Stories
- As a user, I want to be able to add a song to a playlist
- As a user, I want to be able to view names of all songs in a playlist
- As a user, I want to be able to select a song and see information about that song
- As a user, I want to be able to rate a song on a scale of one to five stars
- As a user, I want to be able to save my playlist to a file
- As a user, I want the option to be able to load my playlist from file
- As a user, I want to be able to save a playlist to file.

## Instructions for Grader
- You can generate the first required event related to adding Xs to a Y by clicking select song and pressing delete
song to delete the song from playlist. You can delete more than one song at a time.
- You can generate the second required event related to adding Xs to a Y by selecting a song and clicking Change Rank,
to change the rank of selected song. You can select and change rank for more than one song.
- You can locate the visual component by clicking the add song button.
- You can save the state of my application by clicking Save Playlist.
- You can load the state of my playlist by clicking Load Playlist.

## Phase 4: Task 2
Tue Nov 29 10:18:22 MST 2022
Added song:Take A Slice
Tue Nov 29 10:18:59 MST 2022
Added song:All I Want For Christmas
Tue Nov 29 10:20:12 MST 2022
Added song:Young Dumb and Broke
Tue Nov 29 10:20:16 MST 2022
Removed song: Young Dumb and Broke

## Phase 4: Task 3
Looking at my UML diagram and at my project design, one thing I would think to 
change is the amount of classes included in the ui package. Each component of my app frame had its
own class but looking back I realized that some of these classes didn't
have to be its own class. For example having a separate class for my TitleBar is 
unnecessary as It doesn't have to be its own class and could have just been implemented insie AppFrame. 
However, having separate classes for the bigger components
of my app frame such as my SongInfo class made implementing my GUI easier.
