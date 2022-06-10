package ru.furestry.alphabanktest.entities.gif;

import lombok.Data;

import java.util.List;

/**
 * A class that presents the response in json format from <a href="https://developers.giphy.com/docs/api/endpoint/#search">/search giphy endpoint</a>
 *
 * @author Sevler
 */
@Data
public class Gif {
    private List<GifData> data;

    private Pagination pagination;

    private Meta meta;
}
