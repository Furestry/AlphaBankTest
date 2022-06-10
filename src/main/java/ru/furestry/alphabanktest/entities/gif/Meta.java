package ru.furestry.alphabanktest.entities.gif;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * A class that presents the <a href="https://developers.giphy.com/docs/api/schema/#meta-object">meta object</a>
 *
 * @author Sevler
 */
@Data
public class Meta {
    private String msg;

    private int status;

    @JsonProperty("response_id")
    private String responseId;
}
