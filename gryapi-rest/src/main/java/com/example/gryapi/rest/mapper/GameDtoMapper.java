package com.example.gryapi.rest.mapper;

import com.example.gryapi.rest.dto.GameDto;
import com.example.gryapi.db.model.GameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameDtoMapper {
    @Autowired
    private GenreDtoMapper genreDtoMapper;
    @Autowired
    private PublisherDtoMapper publisherDtoMapper;

    public GameDto map(GameEntity gameEntity) {
        if (gameEntity == null) {
            return null;
        }
        return new GameDto(
                gameEntity.getId(),
                gameEntity.getTitle(),
                gameEntity.getPublishYear(),
                publisherDtoMapper.map(gameEntity.getPublisher()),
                genreDtoMapper.map(gameEntity.getGenre())
        );
    }
}

