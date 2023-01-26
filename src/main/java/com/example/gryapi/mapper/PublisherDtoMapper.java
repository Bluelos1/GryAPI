package com.example.gryapi.mapper;

import com.example.gryapi.dto.PublisherDto;
import com.example.gryapi.model.PublisherEntity;
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
