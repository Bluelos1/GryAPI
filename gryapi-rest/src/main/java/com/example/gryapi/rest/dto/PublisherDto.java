package com.example.gryapi.rest.dto;

import java.io.Serializable;

public class PublisherDto implements Serializable {
    private Long id;
    private String name;
    private String country;
    private int numberOfEmployees;
    private int foundationYear;

    public PublisherDto() {
    }

    public PublisherDto(Long id, String name, String country, int numberOfEmployees, int foundationYear) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.numberOfEmployees = numberOfEmployees;
        this.foundationYear = foundationYear;
    }

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
