package ru.furestry.alphabanktest.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign Client for working with <a href="https://developers.giphy.com/docs/api/">giphy API</a>
 *
 * @author Sevler
 */
@FeignClient(name = "gifs", url = "${url.gif}")
public interface GifClient {
    /**
     * Retrieves a gif from the giphy service
     *
     * @param apiKey the apiKey to set
     * @param offset the offset to set
     * @param query the query to set
     * @return the response from the giphy API
     */
    @GetMapping(value = "?api_key={apiKey}&q={query}&limit=1&offset={offset}&rating=g&lang=en")
    String getGif(@PathVariable("apiKey") String apiKey, @PathVariable("offset") int offset, @PathVariable("query") String query);

}
