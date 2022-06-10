package ru.furestry.alphabanktest.entities.gif;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * A class that presents the <a href="https://developers.giphy.com/docs/api/schema/#pagination-object">pagination object</a>
 *
 * @author Sevler
 */
@Data
public class Pagination {
    private int offset;

    @JsonProperty("total_count")
    private int totalCount;

    private int count;
}
