package ru.furestry.alphabanktest.entities.gif;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * A class that presents the <a href="https://developers.giphy.com/docs/api/schema/#gif-object">gif object</a>
 *
 * @author Sevler
 */
@Data
public class GifData {
    private String type;

    private String id;

    private String slug;

    private String url;

    @JsonProperty("bitly_gif_url")
    private String bitlyGifUrl;

    @JsonProperty("bitly_url")
    private String bitlyUrl;

    @JsonProperty("embed_url")
    private String embedUrl;

    private String username;

    private Map<String, Object> user;

    private String source;

    private String rating;

    @JsonProperty("content_url")
    private String contentUrl;

    @JsonProperty("source_tld")
    private String sourceTld;

    @JsonProperty("source_post_url")
    private String sourcePostUrl;

    @JsonProperty("update_datetime")
    private String updateDatetime;

    @JsonProperty("create_datetime")
    private String createDatetime;

    @JsonProperty("is_sticker")
    private int isSticker;

    @JsonProperty("import_datetime")
    private String importDatetime;

    @JsonProperty("trending_datetime")
    private String trendingDatetime;

    private Map<String, Object> images;

    private String title;

    @JsonProperty("analytics_response_payload")
    private String analyticsResponsePayload;

    private Map<String, Object> analytics;
}
