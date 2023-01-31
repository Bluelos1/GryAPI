package com.example.gryapi.rest.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CreateGameDto {
    @NotNull
    private String title;
    @Min(1800)
    private int publishYear;
    @Min(1)
    private Long publisherId;
    @Min(1)
    private Long genreId;

    public CreateGameDto(String title, int publishYear, Long publisherId, Long genreId) {
        this.title = title;
        this.publishYear = publishYear;
        this.publisherId = publisherId;
        this.genreId = genreId;
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



