package com.example.gryapi.dto;

public class GameDto {

    private Long id;

    private String title;

    private int publishYear;

    private PublisherDto publisher;

    private GenreDto genre;

    public GameDto() {
    }

    public GameDto(Long id, String title, int publishYear, PublisherDto publisher, GenreDto genre) {
        this.id = id;
        this.title = title;
        this.publishYear = publishYear;
        this.publisher = publisher;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public PublisherDto getPublisher() {
        return publisher;
    }

    public GenreDto getGenre() {
        return genre;
    }
}
