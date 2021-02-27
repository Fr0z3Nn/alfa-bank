
package ru.project.alfastonks.service.Impl;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.project.alfastonks.client.DownloadClient;
import ru.project.alfastonks.service.DownloadService;

import java.net.URI;

@Service
@Data
public class DownloadServiceImpl implements DownloadService {
    private final DownloadClient downloadClient;

    @Override
    public ResponseEntity<byte[]> getGifByUrl(URI uri) {
        return downloadClient.getGifByUrl(uri);
    }

}

