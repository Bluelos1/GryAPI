package com.example.gryapi.rest.dto;

import jakarta.validation.constraints.NotNull;

public class UpdateGenreDto {
    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAltName() {
        return altName;
    }

    @NotNull
    private String name;

    private String altName;
}
