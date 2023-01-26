package com.example.gryapi.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class GenreEntity implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id", nullable = false)
   private Long id;

   private String name;
   private String altName;

   public GenreEntity(Long id, String name, String altName) {
      this.id = id;
      this.name = name;
      this.altName = altName;
   }

   public GenreEntity(String name, String altName) {
      this.name = name;
      this.altName = altName;
   }

   public GenreEntity() {
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

   public String getAltName() {
      return altName;
   }
}
