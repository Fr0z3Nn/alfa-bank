package ru.project.alfastonks.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CurrencyDTO {
    private String disclaimer;
    private String license;
    private long timestamp;
    private String base;
    private Map<String , Double> rates;
}
