package com.example.gryapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UpdatePublisherDto {

    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String country;
    @Min(0)
    private int numberOfEmployees;
    @Min(0)
    private int foundationYear;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public int getFoundationYear() {
        return foundationYear;
    }
}
