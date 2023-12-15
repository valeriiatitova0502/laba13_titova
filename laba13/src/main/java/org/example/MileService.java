package org.example;

import org.springframework.stereotype.Component;

@Component
public class MileService {

    public void sendFavoritesToEmail(String songName, Action action) {
        String message = songName + " " + action.getDescription();
        System.out.println(message);
    }
}