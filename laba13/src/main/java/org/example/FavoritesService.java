package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FavoritesService {

    private final Map<Song, String> favorites;

    @Autowired
    private Playlist playlist;

    @Autowired
    private MileService mileService;

    @Autowired
    private SongService songService;

    @Autowired
    private SongRequest songRequest;

    public FavoritesService() {
        this.favorites = new HashMap<>();
    }

    @PostConstruct
    public void init() {
    }

    public boolean isSongInFavorites(Song song) {
        return favorites.containsKey(song);
    }

    public void printUpdatedFavorites() {
        System.out.println("\nОбновленное избранное перед удалением:");
        printFavorites();
    }

    public boolean addToFavorites(Song song) {
        String formattedDate = getCurrentTime();
        if (favorites.put(song, formattedDate) == null) {
            mileService.sendFavoritesToEmail(song.getName(), Action.ADDED);
            return true; // Успешное добавление
        } else {
            mileService.sendFavoritesToEmail(song.getName(), Action.REMOVED);
            return false; // Песня уже в избранном
        }
    }

    public boolean removeFromFavorites(Song song) {
        if (favorites.remove(song) != null) {
            mileService.sendFavoritesToEmail(song.getName(), Action.REMOVED);
            return true; // Успешное удаление
        } else {
            mileService.sendFavoritesToEmail(song.getName(), Action.ADDED);
            return false; // Песня не найдена, операция не выполнена
        }
    }

    public void addSongToFavoriteByName(String songName) {
        Song song = songRequest.findByName(songName);
        if (song != null) {
            addToFavorites(song);
        } else {
            System.out.println("Песня '" + songName + "' не найдена.");
        }
    }

    public void removeSongFromFavoritesByName(String songName) {
        Song song = songRequest.findByName(songName);
        if (song != null) {
            removeFromFavorites(song);
        } else {
            System.out.println("Песня '" + songName + "' не найдена.");
        }
    }

    public List<Song> getFavorites() {
        return new ArrayList<>(favorites.keySet());
    }

    public void printFavorites() {
        System.out.println("\nИзбранное:");
        for (Map.Entry<Song, String> entry : favorites.entrySet()) {
            System.out.println(entry.getKey().printInfo());
        }
    }

    public void addToPlaylistFromFavorites() {
        List<Song> favoriteSongs = getFavorites();
        addToPlaylist(favoriteSongs);
    }

    private void addToPlaylist(List<Song> allSongs) {
        playlist.setSongs(allSongs);
        updatePlaylist();
    }

    public void updatePlaylist() {
        List<Song> allSongs = songService.getAllSongs();
        playlist.setSongs(allSongs);
        playlist.displayPlaylist();
    }

    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(new Date());
    }
}