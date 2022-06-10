package ru.furestry.alphabanktest.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.stereotype.Service;
import ru.furestry.alphabanktest.clients.ExchangeClient;
import ru.furestry.alphabanktest.entities.ResponseView;
import ru.furestry.alphabanktest.entities.exchange.Historical;
import ru.furestry.alphabanktest.entities.exchange.Latest;

import java.time.LocalDate;
import java.util.Map;

/**
 * A class that is used to retrieve rates from the openexchangerates
 *
 * @author Sevler
 */
@Service
public class ExchangeService {
    private final ExchangeClient exchangeClient;
    private final GifService gifService;
    private final String currency;
    private final String openexchangeKey;
    private final JsonMapper mapper;

    /**
     * Class constructor
     *
     * @param exchangeClient the exchangeClient to set
     * @param gifService the gifService to set
     * @param openexchangeKey the openexchange API key to set
     * @param currency the currency to set
     */
    public ExchangeService(ExchangeClient exchangeClient, GifService gifService, String openexchangeKey, String currency) {
        this.exchangeClient = exchangeClient;
        this.gifService = gifService;
        this.currency = currency;
        this.openexchangeKey = openexchangeKey;

        mapper = new JsonMapper();
    }

    /**
     * Method for obtaining status of the currency rate
     *
     * @param symbol the currency to get the rate for
     * @return response view with the rate state and the gif
     */
    public ResponseView getRate(String symbol) {
        double currentRate = getTodayExchangeRate(symbol);
        double yesterdayRate = getYesterdayExchangeRate(symbol);
        String query = currentRate > yesterdayRate ? "Rich" : "Broke";

        Map<String, Object> original = gifService.getGif(query);

        ResponseView gif = new ResponseView(
                query,
                original.get("height").toString(),
                original.get("width").toString(),
                original.get("url").toString()
        );

        return gif;
    }

    /**
     * Method to get the current value of the specified currency
     *
     * @param symbol the currency to get the rate for
     * @return a double value of current rate for the specified currency
     */
    private double getTodayExchangeRate(String symbol) {
        try {
            Latest latest = mapper.readValue(exchangeClient.getLatest(openexchangeKey, currency, symbol), Latest.class);
            return latest.getRates().get(symbol);
        } catch (JsonProcessingException e ) {
            e.printStackTrace();
            return 0.0;
        }
    }

    /**
     * Method to get yesterday's value of the specified currency
     *
     * @param symbol the currency to get the rate for
     * @return a double value of yesterday's rate for the specified currency
     */
    private double getYesterdayExchangeRate(String symbol) {
        LocalDate tomorrow = LocalDate.now().minusDays(1L);

        try {
            Historical historical = mapper.readValue(exchangeClient.getHistorical(tomorrow.toString(), openexchangeKey, currency, symbol), Historical.class);

            return historical.getRates().get(symbol);
        } catch (JsonProcessingException e ) {
            e.printStackTrace();
            return 0.0;
        }
    }
}
