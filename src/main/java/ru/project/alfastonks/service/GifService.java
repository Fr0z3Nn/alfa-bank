package ru.project.alfastonks.service;

import org.springframework.http.ResponseEntity;
import ru.project.alfastonks.dto.GifDTO;

public interface GifService {
    ResponseEntity<GifDTO> getGifResponse(String tag);
}