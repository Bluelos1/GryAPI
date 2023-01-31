package com.example.gryapi.rest.controller;

import com.example.gryapi.rest.dto.CreateGenreDto;
import com.example.gryapi.rest.dto.GenreDto;
import com.example.gryapi.rest.dto.UpdateGenreDto;
import com.example.gryapi.rest.service.GenreService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/genres")
public class GenreController {
    Logger logger = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private GenreService genreService;

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<GenreDto> getGenreEntity(@PathVariable Long id) {
        logger.info("Serving GET request for GenreEntity with id = " + id);
        Optional<GenreDto> genreDto = genreService.getById(id);
        if(genreDto.isEmpty()){
            logger.info("GenreEntity not found with id = " + id);
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
        return ResponseEntity.ok(genreDto.get());
    }

    @PostMapping
    public Long createGenre(@Valid @RequestBody CreateGenreDto createGenreDto){
        logger.info("Creating new genreEntity");
        return genreService.createGenre(createGenreDto.getName(), createGenreDto.getAltName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGenre(@PathVariable Long id){
        logger.info("Deleting genreEntity with id = " + id);
        try {
            genreService.deleteGenre(id);
            return ResponseEntity.ok(null);
        } catch (EmptyResultDataAccessException e){
            return new ResponseEntity<>("Genre with id = " + id + " does not exist", HttpStatusCode.valueOf(400));
        }
    }
    @PutMapping
    public ResponseEntity<Object> updateGenre(@Valid @RequestBody UpdateGenreDto updateGenreDto) {
        logger.info("Updating genreEntity with id = " + updateGenreDto.getId());
        try {
            return ResponseEntity.ok(genreService.updateGenre(
                    updateGenreDto.getId(),
                    updateGenreDto.getName(),
                    updateGenreDto.getAltName()
            ));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(400));
        }
    }
}
