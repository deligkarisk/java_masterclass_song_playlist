package com.deligkarisk;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Album {

    List<Song> albumSongs;
    String name;
    String artist;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.albumSongs = new ArrayList<>();
    }

    public Boolean addSong(String title, String duration) {
        if (findSong(title).isEmpty()) {
            albumSongs.add(new Song(title, duration));
            return true;
        }
        return false;
    }


    private Optional<Song> findSong(String title) {
        for (Song albumSong : albumSongs) {
            if (albumSong.getTitle().equals(title)) {
                return Optional.of(albumSong);
            }
        }
        return Optional.empty();
    }
}
