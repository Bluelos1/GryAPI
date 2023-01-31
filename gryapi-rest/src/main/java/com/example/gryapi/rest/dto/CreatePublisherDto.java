package com.example.gryapi.rest.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CreatePublisherDto {
    @NotNull
    private String name;
    @NotNull
    private String country;
    @Min(0)
    private int numberOfEmployees;
    @Min(0)
    private int foundationYear;

    public CreatePublisherDto(String name, String country, int numberOfEmployees, int foundationYear) {
        this.name = name;
        this.country = country;
        this.numberOfEmployees = numberOfEmployees;
        this.foundationYear = foundationYear;
    }

    public CreatePublisherDto() {
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
