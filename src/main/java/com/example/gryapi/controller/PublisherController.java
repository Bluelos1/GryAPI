package com.example.gryapi.controller;

import com.example.gryapi.dto.CreatePublisherDto;
import com.example.gryapi.dto.PublisherDto;
import com.example.gryapi.mapper.PublisherDtoMapper;
import com.example.gryapi.model.PublisherEntity;
import com.example.gryapi.service.PublisherService;
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
@RequestMapping("/publisher")
public class PublisherController {
    Logger logger = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private PublisherService publisherService;
    @Autowired
    private PublisherDtoMapper publisherDtoMapper;

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<PublisherDto> getPublisherEntity(@PathVariable Long id){
        Optional<PublisherEntity> publisherEntity = publisherService.getById(id);
        if(publisherEntity.isEmpty()){
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
        return ResponseEntity.ok(publisherDtoMapper.map(publisherEntity.get()));
    }

    @PostMapping
    public Long createPublisherEntity(@Valid @RequestBody CreatePublisherDto createPublisherDto){
        logger.info("Creating new publisherEntity");
        return publisherService.createPublisher(
                createPublisherDto.getName(),
                createPublisherDto.getCountry(),
                createPublisherDto.getNumberOfEmployees(),
                createPublisherDto.getFoundationYear()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePublisher(@PathVariable Long id){
        logger.info("Deleting publisherEntity with id = " + id);
        try {
            publisherService.deletePublisher(id);
            return ResponseEntity.ok(null);
        } catch (EmptyResultDataAccessException e){
            return new ResponseEntity<>("Publisher with id = " + id + " does not exist", HttpStatusCode.valueOf(400));
        }
    }
}
