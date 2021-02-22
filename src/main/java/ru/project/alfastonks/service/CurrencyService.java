package ru.project.alfastonks.service;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.project.alfastonks.client.CurrencyClient;
import ru.project.alfastonks.client.GifClient;
import ru.project.alfastonks.dto.CurrencyDTO;

@Service
@Data
public class CurrencyService {
    private final CurrencyClient currencyClient;

    private final String API_KEY = "d1cab48c796546b6a3491f5347e11517";

    public ResponseEntity<?> getCurrency(String base) {
        ResponseEntity<CurrencyDTO> entity = currencyClient.getCurrency("2021-02-22",API_KEY,base);
        System.out.println(entity.getBody().getRates().get("RUB"));
        return currencyClient.getCurrency("2021-02-22",API_KEY,base);
    }
}
