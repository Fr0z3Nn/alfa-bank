package ru.project.alfastonks.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.project.alfastonks.service.GifService;

@Data
@RestController
@RequestMapping("/api")
public class CurrencyController {

    private final GifService gifService;

    @GetMapping("/gif")
    public ResponseEntity<?> getGifByCurrency(@RequestParam("tag") String tag){
        return gifService.getGif(tag);
    }
}
