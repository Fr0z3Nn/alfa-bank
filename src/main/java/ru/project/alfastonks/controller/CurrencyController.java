package ru.project.alfastonks.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.project.alfastonks.service.GifOnCurrencyExchangeRateService;



@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CurrencyController {

    private final GifOnCurrencyExchangeRateService gif;

    @GetMapping("/gif")
    public ResponseEntity<byte[]> getGifByCurrency(@RequestParam("base") String base) {
        return gif.getGifByCurrency(base);
    }

    @GetMapping("/*")
    public ResponseEntity<byte[]> getGifByCurrency() {
        return gif.getGifByCurrency("USD");
    }
}
