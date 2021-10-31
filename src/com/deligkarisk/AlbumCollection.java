package com.deligkarisk;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlbumCollection {

    List<Album> albums;

    public AlbumCollection() {
        Album ironMaidenBestOf = makeIronMaidenAlbum();
        Album icedEarthBestOf = makeIcedEarthAlbum();
        Album rainbowBestOf = makeRainbowAlbum();

        albums = new ArrayList<>();

        albums.add(ironMaidenBestOf);
        albums.add(icedEarthBestOf);
        albums.add(rainbowBestOf);
    }


    public Optional<Album> findAlbum(String albumTitle) {
        for (Album album : albums) {
            if (album.getTitle().equals(albumTitle)) {
                return Optional.of(album);
            }
        }

        return Optional.empty();
    }

    private static Album makeIronMaidenAlbum() {
        Album ironMaidenAlbum = new Album("Iron Maiden Best Of", "Iron Maiden");
        ironMaidenAlbum.addSong("Aces high", "3:55");
        ironMaidenAlbum.addSong("Rime of the ancient mariner", "8:43");
        ironMaidenAlbum.addSong("Powerslave", "4:38");

        return ironMaidenAlbum;
    }

    private static Album makeIcedEarthAlbum() {
        Album icedEarthAlbum = new Album("Iced Earth Best Of", "Iced Earth");
        icedEarthAlbum.addSong("Consequences", "2:32");
        icedEarthAlbum.addSong("Watching over me", "4:21");
        icedEarthAlbum.addSong("Dracula", "4:29");

        return icedEarthAlbum;
    }

    private static Album makeRainbowAlbum() {
        Album rainbowAlbum = new Album("Rainbow Best Of", "Rainbow");
        rainbowAlbum.addSong("Catch the rainbow", "3:55");
        rainbowAlbum.addSong("Since you have been gone", "5:29");
        rainbowAlbum.addSong("Temple of the king", "3:23");

        return rainbowAlbum;
    }
}
