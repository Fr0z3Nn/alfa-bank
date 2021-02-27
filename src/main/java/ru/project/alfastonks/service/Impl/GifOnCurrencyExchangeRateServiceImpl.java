package ru.project.alfastonks.service.Impl;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.project.alfastonks.dto.CurrencyDTO;
import ru.project.alfastonks.dto.GifDTO;
import ru.project.alfastonks.exception.BadBaseException;
import ru.project.alfastonks.service.CurrencyService;
import ru.project.alfastonks.service.DownloadService;
import ru.project.alfastonks.service.GifOnCurrencyExchangeRateService;
import ru.project.alfastonks.service.GifService;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;


@Service
@Data
public class GifOnCurrencyExchangeRateServiceImpl implements GifOnCurrencyExchangeRateService {
    private final GifService gifService;
    private final CurrencyService currencyService;
    private final DownloadService downloadService;

    public ResponseEntity<byte[]> getGifByCurrency(String base) {
        if (isBaseNotValid(base)) {
            throw new BadBaseException("Валюта должна состоять из 3х символов");
        }
        String todayDate = formatDateFromNow(0);
        String yesterdayDate = formatDateFromNow(1);
        double todayRate = getRateByDateAndBase(todayDate, base);
        double yesterdayRate = getRateByDateAndBase(yesterdayDate, base);
        String tag = (todayRate > yesterdayRate) ? "rich" : "broke";
        URI basePathUri = URI.create(getGifUrlByTag(tag));
        return downloadService.getGifByUrl(basePathUri);
    }

    private boolean isBaseNotValid(String base) {
        return base.length() != 3;
    }

    private String formatDateFromNow(int days) {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(days);
        return DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(dateTime);
    }

    private double getRateByDateAndBase(String date, String base) {
        CurrencyDTO currencyDTO = currencyService.getCurrency(date, base).getBody();
        return Objects.requireNonNull(currencyDTO).getRates().get("RUB");
    }

    private String getGifUrlByTag(String tag) {
        GifDTO gifDTO = gifService.getGifResponse(tag).getBody();
        return String.valueOf(Objects.requireNonNull(gifDTO).getData().get("image_original_url"));
    }
}


