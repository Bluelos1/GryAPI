package com.example.gryapi.service;

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

    @Cacheable(value = "publishers", key = "#id")
    public Optional<PublisherEntity> getById(Long id){
        return publisherRepository.findById(id);
    }

    public Long createPublisher(String name, String country, int numberOfEmployees, int foundationYear){
        PublisherEntity publisher = new PublisherEntity(name, country, numberOfEmployees, foundationYear);
        return publisherRepository.save(publisher).getId();
    }

    @CacheEvict(value = "publishers", key = "#id")
    public void deletePublisher(Long id){
        publisherRepository.deleteById(id);
    }
}
