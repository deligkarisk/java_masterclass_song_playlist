package com.deligkarisk;

import java.util.*;

public class Main {

    private static AlbumCollection albumCollection = new AlbumCollection();
    private static Playlist playlist = new Playlist(albumCollection);

    public static void main(String[] args) {
	// write your code here


        playlist.addSong("Iron Maiden Best Of","Rime of the ancient mariner");
        playlist.addSong("Iced Earth Best Of","Dracula");
        playlist.addSong("Iron Maiden Best Of","Powerslave" );
        playlist.addSong("Rainbow Best Of","Catch the rainbow" );
        playlist.addSong("Rainbow Best Of", "Temple of the king");

        play(playlist);

    }


    private static void play(Playlist listToPlay) {

        List<Song> playlist = listToPlay.getPlaylist();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the playlist.");
        System.out.println("Enter a number:");
        System.out.println("1: Forward to the next song.");
        System.out.println("2: Backwards to a previous song.");
        System.out.println("3: (Re) play the current song.");
        System.out.println("4: List the songs of the playlist.");
        System.out.println("5: Quit.");

        boolean quit = false;
        ListIterator<Song> playlistIterator = playlist.listIterator();
        boolean goingForward = true;

        while (!quit) {
            System.out.println("Enter your selection:");
            int selection = scanner.nextInt();
            scanner.nextLine();
            switch(selection) {
                case 1:
                    if (!goingForward) {
                        if (playlistIterator.hasNext()) {
                            playlistIterator.next();
                            goingForward = true;
                        }
                    }

                    if (playlistIterator.hasNext()) {
                        System.out.println("Now playing " + playlistIterator.next().getTitle());
                    } else {
                        System.out.println("We are already at the end of the playlist.");
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (playlistIterator.hasPrevious()) {
                            playlistIterator.previous();
                            goingForward = false;
                        }
                    }

                    if (playlistIterator.hasPrevious()) {
                        System.out.println("Now playing " + playlistIterator.previous().getTitle());;
                    } else {
                        System.out.println("We are already at the beginning of the list.");
                    }
                    break;
                case 3:
                    if (goingForward) {
                        if (playlistIterator.hasPrevious()) {
                            System.out.println("Now playing " + playlistIterator.previous().getTitle());
                            goingForward = false;
                        } else {
                            System.out.println("Now playing " + playlistIterator.next().getTitle());;
                        }
                        break;
                    }

                    if (!goingForward) {
                        if (playlistIterator.hasNext()) {
                            System.out.println("Now playing " + playlistIterator.next().getTitle());
                            goingForward = true;
                        } else {
                            // This probably will never happen, we can never be at the last position and be going
                            // backwards, as this means we came from the last+1 position, which is impossible.
                            System.out.println("Now playing " + playlistIterator.previous().getTitle());
                        }
                        break;
                    }

                case 4:
                    for (Song song : playlist) {
                        System.out.println(song.getTitle() + ", at " + song.getDuration());
                    }
                    break;
                case 5:
                    quit = true;
                    break;
            }



        }

    }






}
