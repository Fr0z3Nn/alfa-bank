package ru.project.alfastonks.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GifDTO {
    String api_key;
    String tag;
    String rating;
}
