package com.example.gryapi.service;

import com.example.gryapi.model.GameEntity;
import com.example.gryapi.model.GenreEntity;
import com.example.gryapi.model.PublisherEntity;
import com.example.gryapi.repository.GameRepository;
import com.example.gryapi.repository.GenreRepository;
import com.example.gryapi.repository.PublisherRepository;
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
    PublisherRepository publisherRepository;
    @Cacheable(value = "games", key = "#id")
    public Optional<GameEntity> getById(Long id){
        return gameRepository.findById(id);
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
}
