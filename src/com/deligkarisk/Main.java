package com.deligkarisk;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Album ironMaidenBestOf = makeIronMaidenAlbum();
        Album icedEarthBestOf = makeIcedEarthAlbum();
        Album rainbowBestOf = makeRainbowAlbum();

        List<Album> albums = new ArrayList<>();

        List<Song> playlist = new LinkedList<>();
        playlist.add(ironMaidenBestOf.albumSongs.get(0));
        playlist.add(icedEarthBestOf.albumSongs.get(2));
        playlist.add(icedEarthBestOf.albumSongs.get(0));
        playlist.add(rainbowBestOf.albumSongs.get(1));
        playlist.add(ironMaidenBestOf.albumSongs.get(1));

        play(playlist);

    }


    private static void play(List<Song> playlist) {
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
                        System.out.println(song.getTitle() + ", by " + song.getDuration());
                    }
                    break;
                case 5:
                    quit = true;
                    break;
            }



        }









    }


    private static Album makeIronMaidenAlbum() {
        Song acesHigh = new Song("Aces high", "3:55");
        Song rimeOfTheAncientMariner = new Song("Rime of the ancient mariner", "8:43");
        Song powerslave = new Song("Powerslave", "4:38");
        List<Song> ironMaidenList = new ArrayList<>();
        ironMaidenList.add(acesHigh);
        ironMaidenList.add(rimeOfTheAncientMariner);
        ironMaidenList.add(powerslave);
        return new Album(ironMaidenList);
    }

    private static Album makeIcedEarthAlbum() {
        Song consequences = new Song("Consequences", "2:32");
        Song watchingOverMe = new Song("Watching over me", "4:21");
        Song dracula = new Song("Dracula", "4:29");
        List<Song> icedEarthList = new ArrayList<>();
        icedEarthList.add(consequences);
        icedEarthList.add(watchingOverMe);
        icedEarthList.add(dracula);
        return new Album(icedEarthList);
    }

    private static Album makeRainbowAlbum() {
        Song catchTheRainbow = new Song("Catch the rainbow", "3:55");
        Song sinceYouHaveBeenGone = new Song("Since you have been gone", "5:29");
        Song templeOfTheKing = new Song("Temple of the king", "3:23");
        List<Song> rainbowList = new ArrayList<>();
        rainbowList.add(catchTheRainbow);
        rainbowList.add(sinceYouHaveBeenGone);
        rainbowList.add(templeOfTheKing);
        return new Album(rainbowList);
    }



}
