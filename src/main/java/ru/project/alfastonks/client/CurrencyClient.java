package ru.project.alfastonks.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.project.alfastonks.dto.CurrencyDTO;

@FeignClient(name = "currency-client", url = "${currency.url}")
public interface CurrencyClient {
    @GetMapping("/{date}.json")
    ResponseEntity<CurrencyDTO> getCurrency(@PathVariable("date") String date,
                                            @RequestParam("app_id") String id,
                                            @RequestParam(value = "base", defaultValue = "USD") String base);
}

