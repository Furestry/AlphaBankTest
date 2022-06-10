package ru.furestry.alphabanktest.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign Client for working with <a href="https://docs.openexchangerates.org/docs">openexchangerates API</a>
 *
 * @author Sevler
 */
@FeignClient(name = "exchange", url = "${url.exchange}")
public interface ExchangeClient {
    /**
     * A method for obtaining the historical value of a currency in relation to another currency
     *
     * @param date the date of the exchange rate
     * @param apiKey the API key
     * @param base the base currency
     * @param symbols the currencies to be converted
     * @return the exchange rate
     */
    @GetMapping(value = "/historical/{date}.json?app_id={apiKey}&base={base}&symbols={symbols}")
    String getHistorical(@PathVariable("date") String date, @PathVariable("apiKey") String apiKey, @PathVariable("base") String base, @PathVariable("symbols") String symbols);

    /**
     * A method for obtaining the current value of a currency in relation to another currency
     *
     * @param apiKey the API key
     * @param base the base currency
     * @param symbols the currencies to be converted
     * @return the exchange rate
     */
    @GetMapping(value = "/latest.json?app_id={apiKey}&base={base}&symbols={symbols}")
    String getLatest(@PathVariable("apiKey") String apiKey, @PathVariable("base") String base, @PathVariable("symbols") String symbols);
}
