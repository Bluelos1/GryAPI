package com.example.gryapi.db.model;

import jakarta.persistence.*;

@Entity
public class PublisherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String country;
    private int numberOfEmployees;

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

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
