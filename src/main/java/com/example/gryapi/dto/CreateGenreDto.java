package com.example.gryapi.dto;

import jakarta.validation.constraints.NotNull;

public class CreateGenreDto {
    @NotNull
    private String name;

    private String altName;

    public CreateGenreDto() {
    }

    public String getName() {
        return name;
    }

    public String getAltName() {
        return altName;
    }

    public CreateGenreDto(String name, String altName) {
        this.name = name;
        this.altName = altName;
    }
}
