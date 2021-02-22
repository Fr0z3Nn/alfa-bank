package ru.project.alfastonks.service;

import lombok.Data;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.project.alfastonks.client.GifClient;

@Service
@Data
public class GifService {

    private final GifClient gifClient;

    private final String API_KEY = "hidyT0yooJt3jmgfSpg9CsPge7xEEZqb";

    public ResponseEntity<?> getGif(String tag) {
        return gifClient.getGif(API_KEY,tag);
    }
}
