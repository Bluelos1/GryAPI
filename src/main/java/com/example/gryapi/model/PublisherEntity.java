package com.example.gryapi.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class PublisherEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String country;
    private int numberOfEmployees;
    private int foundationYear;

    public PublisherEntity(Long id, String name, String country, int numberOfEmployees, int foundationYear) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.numberOfEmployees = numberOfEmployees;
        this.foundationYear = foundationYear;
    }

    public PublisherEntity(String name, String country, int numberOfEmployees, int foundationYear) {
        this.name = name;
        this.country = country;
        this.numberOfEmployees = numberOfEmployees;
        this.foundationYear = foundationYear;
    }

    public PublisherEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
