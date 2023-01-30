package com.example.gryapi.service;

import com.example.gryapi.model.GenreEntity;
import com.example.gryapi.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;
    @Cacheable(value = "genres", key = "#id")
    public Optional<GenreEntity> getById(Long id) {
        return genreRepository.findById(id);
    }

    public Long createGenre(String name, String altName){
        GenreEntity newGenre = new GenreEntity(name, altName);
        genreRepository.save(newGenre);
        return newGenre.getId();
    }

    @CacheEvict(value = "genres", key = "#id")
    public void deleteGenre(Long id){
        genreRepository.deleteById(id);
    }

    @CacheEvict(value = "genres", key = "#id")
    public GenreEntity updateGenre(Long id, String name, String altName){
        Optional<GenreEntity> entity = genreRepository.findById(id);
        if (entity.isEmpty()){
            throw new IllegalArgumentException("GenreEntity with id = " + id + " does not exist");
        }
        GenreEntity genreEntity = entity.get();
        genreEntity.setName(name);
        genreEntity.setAltName(altName);
        genreRepository.save(genreEntity);
        return genreEntity;
    }

}

