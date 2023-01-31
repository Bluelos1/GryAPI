package com.example.gryapi.rest.mapper;

import com.example.gryapi.rest.dto.PublisherDto;
import com.example.gryapi.db.model.PublisherEntity;
import org.springframework.stereotype.Component;

@Component
public class PublisherDtoMapper {
    public PublisherDto map(PublisherEntity publisherEntity){
        if(publisherEntity == null){
            return null;
        }
        return new PublisherDto(
                publisherEntity.getId(),
                publisherEntity.getName(),
                publisherEntity.getCountry(),
                publisherEntity.getNumberOfEmployees(),
                publisherEntity.getFoundationYear()
        );
    }
}
