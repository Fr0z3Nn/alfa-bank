package ru.project.alfastonks.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(name = "download-gif-client", url = "https://placeholder")
public interface DownloadClient {
    @GetMapping
    ResponseEntity<byte[]> getGifByUrl(URI baseUrl);
}
