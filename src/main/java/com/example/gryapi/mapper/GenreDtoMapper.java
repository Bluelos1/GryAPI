package com.example.gryapi.mapper;

import com.example.gryapi.dto.GenreDto;
import com.example.gryapi.model.GenreEntity;
import org.springframework.stereotype.Component;

@Component
public class GenreDtoMapper {
    public GenreDto map(GenreEntity genreEntity){
        if(genreEntity == null){
            return null;
        }
        return new GenreDto(
                genreEntity.getId(),
                genreEntity.getName(),
                genreEntity.getAltName()
        );
    }

}
