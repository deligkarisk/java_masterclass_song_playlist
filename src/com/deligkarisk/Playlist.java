package com.deligkarisk;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Playlist {

    AlbumCollection albumCollection;
    List<Song> songs;


    public Playlist(AlbumCollection albumCollection) {
        this.albumCollection = albumCollection;
        songs = new LinkedList<>();
    }




    public List<Song> getPlaylist() {
        return List.copyOf(songs);
    }

    public boolean addSong(String album, String songTitle) {
        Optional<Album> optionalAlbum = albumCollection.findAlbum(album);

        if (optionalAlbum.isEmpty()) {
            return false;
        }

        Album currentAlbum = optionalAlbum.get();
        Optional<Song> optionalSong = currentAlbum.findSong(songTitle);

        if (optionalSong.isEmpty()) {
            return false;
        }

        songs.add(optionalSong.get());
        return true;

    }

}
