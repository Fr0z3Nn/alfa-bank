package ru.project.alfastonks.exception.response;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
public class Response {
    private String message;
}