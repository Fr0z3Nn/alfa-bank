package ru.project.alfastonks.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.project.alfastonks.dto.GifDTO;


@FeignClient(name = "gif-client", url = "${gif.url}")
public interface GifClient {
    @GetMapping(value = "/random")
    ResponseEntity<GifDTO> getGif(@RequestParam("api_key") String api_key,
                                  @RequestParam("tag") String tag);
}
