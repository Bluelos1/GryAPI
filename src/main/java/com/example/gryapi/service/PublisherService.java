package com.example.gryapi.service;

import com.example.gryapi.dto.PublisherDto;
import com.example.gryapi.mapper.PublisherDtoMapper;
import com.example.gryapi.model.PublisherEntity;
import com.example.gryapi.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private PublisherDtoMapper publisherDtoMapper;

    @Cacheable(value = "publishers", key = "#id")
    public Optional<PublisherDto> getById(Long id){
        Optional<PublisherEntity> byId = publisherRepository.findById(id);
        if (byId.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(publisherDtoMapper.map(byId.get()));
    }

    public Long createPublisher(String name, String country, int numberOfEmployees, int foundationYear){
        PublisherEntity publisher = new PublisherEntity(name, country, numberOfEmployees, foundationYear);
        return publisherRepository.save(publisher).getId();
    }

    @CacheEvict(value = "publishers", key = "#id")
    public void deletePublisher(Long id){
        publisherRepository.deleteById(id);
    }

    @CacheEvict(value = "publishers", key = "#id")
    public PublisherDto updatePublisher(Long id, String name, String country, int numberOfEmployees, int foundationYear ){
        Optional<PublisherEntity> entity = publisherRepository.findById(id);
        if (entity.isEmpty()){
            throw new IllegalArgumentException("PublisherEntity with id = " + id + " does not exist");
        }
        PublisherEntity publisherEntity = entity.get();
        publisherEntity.setName(name);
        publisherEntity.setCountry(country);
        publisherEntity.setNumberOfEmployees(numberOfEmployees);
        publisherEntity.setFoundationYear(foundationYear);
        publisherRepository.save(publisherEntity);
        return publisherDtoMapper.map(publisherEntity);
    }

}
