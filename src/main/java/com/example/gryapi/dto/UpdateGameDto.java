package com.example.gryapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UpdateGameDto {
    @NotNull
    private Long id;
    @NotNull
    private String title;
    @Min(1800)
    private int publishYear;
    @Min(1)
    private Long publisherId;
    @Min(1)
    private Long genreId;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public Long getGenreId() {
        return genreId;
    }
}
