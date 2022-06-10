package ru.furestry.alphabanktest.entities.exchange;

import lombok.Data;

import java.util.Map;

/**
 * A class that presents the response in json format from {@link <a href="https://docs.openexchangerates.org/docs/historical-json">/historical openexchangerates endpoint</a>}
 *
 * @author Sevler
 */
@Data
public class Historical {
    private String disclaimer;

    private String license;

    private long timestamp;

    private String base;

    private Map<String, Double> rates;
}
