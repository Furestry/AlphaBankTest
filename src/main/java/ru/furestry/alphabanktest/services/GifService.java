package ru.furestry.alphabanktest.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.furestry.alphabanktest.clients.GifClient;
import ru.furestry.alphabanktest.entities.gif.Gif;

import java.util.Map;

/**
 * A class that is used to retrieve gifs from the giphy
 *
 * @author Sevler
 */
@Service
public class GifService {
    private final GifClient gifClient;
    private final String giphyApiKey;
    private final JsonMapper mapper;

    /**
     * Class constructor
     *
     * @param gifClient the gifClient to set
     * @param giphyKey the giphy API key to set
     */
    public GifService(GifClient gifClient, String giphyKey) {
        this.gifClient = gifClient;
        this.giphyApiKey = giphyKey;

        mapper = new JsonMapper();
    }

    /**
     * Method to get a gif by the query
     *
     * @param query the query to get the gif for
     * @return a map with the gif data
     */
    @Nullable
    public Map<String, Object> getGif(String query) {
        int offset = (int) (Math.random() * 5000);

        try {
            Gif gif = mapper.readValue(gifClient.getGif(giphyApiKey, offset, query), Gif.class);

            while (gif.getData().size() == 0) {
                gif = mapper.readValue(gifClient.getGif(giphyApiKey, offset, query), Gif.class);
            }

            Map<String, Object> original = (Map<String, Object>) gif.getData().get(0).getImages().get("original");

            return original;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
