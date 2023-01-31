package com.example.gryapi.rest.service;

import com.example.gryapi.rest.dto.GenreDto;
import com.example.gryapi.rest.mapper.GenreDtoMapper;
import com.example.gryapi.db.model.GenreEntity;
import com.example.gryapi.db.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GenreDtoMapper genreDtoMapper;

    @Cacheable(value = "genres", key = "#id")
    public Optional<GenreDto> getById(Long id) {
        Optional<GenreEntity> byId = genreRepository.findById(id);
        if (byId.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(genreDtoMapper.map(byId.get()));
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
    public GenreDto updateGenre(Long id, String name, String altName){
        Optional<GenreEntity> entity = genreRepository.findById(id);
        if (entity.isEmpty()){
            throw new IllegalArgumentException("GenreEntity with id = " + id + " does not exist");
        }
        GenreEntity genreEntity = entity.get();
        genreEntity.setName(name);
        genreEntity.setAltName(altName);
        genreRepository.save(genreEntity);
        return genreDtoMapper.map(genreEntity);
    }

}

