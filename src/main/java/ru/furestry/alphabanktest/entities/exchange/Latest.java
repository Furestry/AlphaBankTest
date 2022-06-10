package ru.furestry.alphabanktest.entities.exchange;

import lombok.Data;

import java.util.Map;

/**
 * A class that presents the response in json format from <a href="https://docs.openexchangerates.org/docs/latest-json">/latest openexchangerates endpoint</a>
 *
 * @author Sevler
 */
@Data
public class Latest {
    private String disclaimer;

    private String license;

    private long timestamp;

    private String base;

    private Map<String, Double> rates;
}
