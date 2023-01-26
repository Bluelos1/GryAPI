package com.example.gryapi.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class GameEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;

    private int publishYear;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;

    public GameEntity(Long id, String title, int publishYear, PublisherEntity publisher, GenreEntity genre) {
        this.id = id;
        this.title = title;
        this.publishYear = publishYear;
        this.publisher = publisher;
        this.genre = genre;
    }

    public GameEntity(String title, int publishYear, PublisherEntity publisher, GenreEntity genre) {
        this.title = title;
        this.publishYear = publishYear;
        this.publisher = publisher;
        this.genre = genre;
    }

    public GameEntity() {
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }

    public PublisherEntity getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherEntity publisher) {
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getPublishYear() {
        return publishYear;
    }
}
