package ru.furestry.alphabanktest.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Application configuration class
 *
 * @author Sevler
 */
@Configuration
public class Config {
    @Value("${api.openexchangeKey}")
    private String openexchangeKey;

    @Value("${api.giphyKey}")
    private String giphyKey;

    @Value("${currency}")
    private String currency;

    /**
     * Bean for openexchangerates API key
     *
     * @return String openexchangerates API key
     */
    @Bean(name = "openexchangeKey")
    public String getOpenexchangeKey() {
        return openexchangeKey;
    }

    /**
     * Bean for giphy API key
     *
     * @return String giphy API key
     */
    @Bean(name = "giphyKey")
    public String getGiphyKey() {
        return giphyKey;
    }

    /**
     * Bean for openexchangerates base currency
     *
     * @return String base currency
     */
    @Bean(name = "currency")
    public String getCurrency() {
        return currency;
    }
}
