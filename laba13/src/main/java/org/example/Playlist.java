// Playlist.java
package org.example;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Playlist {

    private List<Song> songs;

    public Playlist() {
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void displayPlaylist() {
        System.out.println("Плейлист:");
        for (Song song : songs) {
            System.out.println(song.printInfo());
        }
    }
}