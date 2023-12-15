// SongService.java

package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// Класс SongService, предоставляющий сервис по управлению песнями.
@Component
public class SongService {

    // Список всех песен.
    private final List<Song> songs;

    // Ссылка на плейлист, который используется для инициализации песен.
    private Playlist playlist;

    // Конструктор для инициализации списка песен и плейлиста.
    @Autowired
    public SongService(Playlist playlist) {
        this.songs = new ArrayList<>();
        songs.add(new Song(1, "Песня1", "Певец1", "3:30"));
        songs.add(new Song(2, "Песня2", "Певец2", "4:15"));
        songs.add(new Song(3, "Песня3", "Певец3", "4:25"));
        songs.add(new Song(4, "Песня4", "Певец4", "4:24"));
        songs.add(new Song(5, "Песня5", "Певец5", "5:24"));

        this.playlist = playlist;
    }

    // Метод для вывода на экран списка всех песен.
    public void printAll() {
        System.out.println("Список всех песен:");
        for (Song song : songs) {
            System.out.println(song.printInfo());
        }
    }

    // Метод для поиска и возврата песни по её имени.
    public Song findAndReturnByName(String name) {
        for (Song song : songs) {
            if (song.getName().equals(name)) {
                return song;
            }
        }
        return null;
    }

    // Метод для поиска песни по её имени.
    public Song findByName(String name) {
        for (Song song : songs) {
            if (song.getName().equals(name)) {
                return song;
            }
        }
        return null;
    }

    // Метод для поиска песни по имени и исполнителю.
    public Song findBySinger(String name, String singer) {
        for (Song song : songs) {
            if (song.getName().equals(name) && song.getSinger().equals(singer)) {
                return song;
            }
        }
        return null;
    }

    // Метод для получения копии списка всех песен.
    public List<Song> getAllSongs() {
        return new ArrayList<>(songs);
    }
}