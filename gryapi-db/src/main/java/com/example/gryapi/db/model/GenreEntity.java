package com.example.gryapi.db.model;

import jakarta.persistence.*;

@Entity
public class GenreEntity{
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

   public void setName(String name) {
      this.name = name;
   }

   public void setAltName(String altName) {
      this.altName = altName;
   }
}
