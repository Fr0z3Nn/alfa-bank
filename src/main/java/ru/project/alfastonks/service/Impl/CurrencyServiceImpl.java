package ru.project.alfastonks.service.Impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.project.alfastonks.client.CurrencyClient;
import ru.project.alfastonks.dto.CurrencyDTO;
import ru.project.alfastonks.service.CurrencyService;

@Service
@Data
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyClient currencyClient;

    private final String API_KEY;

    public CurrencyServiceImpl(CurrencyClient currencyClient, @Value("${currency.api_key}") String API_KEY) {
        this.currencyClient = currencyClient;
        this.API_KEY = API_KEY;
    }

    public ResponseEntity<CurrencyDTO> getCurrency(String date, String base) {
        return currencyClient.getCurrency(date, API_KEY, base);
    }
}
