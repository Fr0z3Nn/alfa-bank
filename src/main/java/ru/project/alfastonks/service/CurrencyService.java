package ru.project.alfastonks.service;

import org.springframework.http.ResponseEntity;
import ru.project.alfastonks.dto.CurrencyDTO;

public interface CurrencyService {
    ResponseEntity<CurrencyDTO> getCurrency(String date, String base);
}
