package com.example.gryapi.controller;

import com.example.gryapi.dto.CreateGameDto;
import com.example.gryapi.dto.GameDto;
import com.example.gryapi.mapper.GameDtoMapper;
import com.example.gryapi.model.GameEntity;
import com.example.gryapi.service.GameService;
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
@RequestMapping("/games")
public class GameController {
    Logger logger = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private GameService gameService;
    @Autowired
    private GameDtoMapper gameDtoMapper;

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<GameDto> getGameEntity(@PathVariable Long id){
        logger.info("Serving GET request for GameEntity with id = " + id);
        Optional<GameEntity> gameEntity = gameService.getById(id);
        if(gameEntity.isEmpty()){
            logger.info("GameEntity not found with id = " + id);
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
       return ResponseEntity.ok(gameDtoMapper.map(gameEntity.get()));
    }

    @PostMapping
    public ResponseEntity<Object> createGame(@Valid @RequestBody CreateGameDto createGameDto){
        logger.info("Creating new gameEntity");
        try {
            return ResponseEntity.ok(gameService.createGame(
                    createGameDto.getTitle(),
                    createGameDto.getPublishYear(),
                    createGameDto.getPublisherId(),
                    createGameDto.getGenreId()
            ));
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(400));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGame(@PathVariable Long id){
        logger.info("Deleting gameEntity with id = " + id);
        try {
            gameService.deleteGame(id);
            return ResponseEntity.ok(null);
        } catch (EmptyResultDataAccessException e){
            return new ResponseEntity<>("Game with id = " + id + " does not exist", HttpStatusCode.valueOf(400));
        }
    }

}
