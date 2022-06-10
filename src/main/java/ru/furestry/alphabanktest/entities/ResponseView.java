package ru.furestry.alphabanktest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * A class that is a repository for creating an html page for the user
 *
 * @author Sevler
 */
@Data
@AllArgsConstructor
public class ResponseView {
    private String title;

    private String height;

    private String width;

    private String url;
}
