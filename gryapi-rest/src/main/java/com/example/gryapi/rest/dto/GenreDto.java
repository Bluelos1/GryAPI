package com.example.gryapi.rest.dto;

import java.io.Serializable;

public class GenreDto implements Serializable {
    private Long id;
    private String name;
    private String altName;

    public GenreDto() {
    }

    public GenreDto(Long id, String name, String altName) {
        this.id = id;
        this.name = name;
        this.altName = altName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAltName() {
        return altName;
    }
}
