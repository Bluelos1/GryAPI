package com.example.gryapi.rest.service;

import com.example.gryapi.db.model.GameEntity;
import com.example.gryapi.db.model.GenreEntity;
import com.example.gryapi.db.model.PublisherEntity;
import com.example.gryapi.db.repository.GameRepository;
import com.example.gryapi.db.repository.GenreRepository;
import com.example.gryapi.db.repository.PublisherRepository;
import com.example.gryapi.rest.dto.GameDto;
import com.example.gryapi.rest.mapper.GameDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GameDtoMapper gameDtoMapper;

    @Autowired
    PublisherRepository publisherRepository;

    @Cacheable(value = "games", key = "#id")
    public Optional<GameDto> getById(Long id){
        Optional<GameEntity> byId = gameRepository.findById(id);
        if (byId.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(gameDtoMapper.map(byId.get()));
    }

    public Long createGame(String title, int publishYear, Long publisherId, Long genreId){
        Optional<PublisherEntity> publisher = publisherRepository.findById(publisherId);
        Optional<GenreEntity> genre = genreRepository.findById(genreId);
        if (publisher.isEmpty() || genre.isEmpty()) {
            throw new IllegalArgumentException("Publisher or genre not found in database");
        }
        GameEntity newGame = new GameEntity(
                title,
                publishYear,
                publisher.get(),
                genre.get()
        );
        gameRepository.save(newGame);
        return newGame.getId();
    }

    @CacheEvict(value = "games", key = "#id")
    public void deleteGame(Long id){
        gameRepository.deleteById(id);
    }

    @CacheEvict(value = "games", key = "#id")
    public GameDto updateGame(Long id, String title, int publisherYear, Long publisherId, Long genreId){
        Optional<GameEntity> entity = gameRepository.findById(id);
        if (entity.isEmpty()){
            throw new IllegalArgumentException("GameEntity with id = " + id + " does not exist");
        }

        Optional<PublisherEntity> publisher = publisherRepository.findById(publisherId);
        Optional<GenreEntity> genre = genreRepository.findById(genreId);
        if (publisher.isEmpty() || genre.isEmpty()) {
            throw new IllegalArgumentException("Publisher or genre not found in database");
        }

        GameEntity gameEntity = entity.get();
        gameEntity.setTitle(title);
        gameEntity.setPublishYear(publisherYear);
        gameEntity.setPublisher(publisher.get());
        gameEntity.setGenre(genre.get());
        gameRepository.save(gameEntity);
        return gameDtoMapper.map(gameEntity);
    }

}
