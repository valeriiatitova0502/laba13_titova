// SongRequest.java
package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SongRequest {


    @Autowired
    private SongService songService;

    public Song findByName(String name) {
        return songService.findByName(name);
    }
}