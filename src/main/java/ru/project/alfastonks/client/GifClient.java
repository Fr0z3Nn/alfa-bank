package ru.project.alfastonks.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "gif-client", url = "https://api.giphy.com/v1/gifs")
public interface GifClient {
    @GetMapping(value = "/random")
    ResponseEntity<?> getGif(@RequestParam("api_key") String api_key, @RequestParam("tag") String tag);
}
