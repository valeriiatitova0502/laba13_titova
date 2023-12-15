package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        FavoritesService favoritesService = context.getBean(FavoritesService.class);

        // Добавление песен в избранное по названию
        favoritesService.addSongToFavoriteByName("Песня1");
        favoritesService.addSongToFavoriteByName("Песня2");
        favoritesService.addSongToFavoriteByName("Песня3");


        // Вывод избранного после добавления
        favoritesService.printFavorites();

        // Удаление песни из избранного по названию
        favoritesService.removeSongFromFavoritesByName("Песня2");
        favoritesService.addSongToFavoriteByName("Песня4");

        // Вывод избранного после удаления
        favoritesService.printFavorites();

        // Добавление избранного в плейлист
        favoritesService.addToPlaylistFromFavorites();

    }
}