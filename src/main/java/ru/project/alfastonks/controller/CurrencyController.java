package ru.project.alfastonks.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.project.alfastonks.service.CurrencyService;

@Data
@RestController
@RequestMapping("/api")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/gif")
    public ResponseEntity<?> getGifByCurrency(@RequestParam("base") String base){
        return currencyService.getCurrency(base);
    }
}
