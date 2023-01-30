package com.example.gryapi.controller;

import com.example.gryapi.dto.CreatePublisherDto;
import com.example.gryapi.dto.PublisherDto;
import com.example.gryapi.dto.UpdatePublisherDto;
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

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<PublisherDto> getPublisherEntity(@PathVariable Long id) {
        Optional<PublisherDto> publisherDto = publisherService.getById(id);
        if (publisherDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
        return ResponseEntity.ok(publisherDto.get());
    }

    @PostMapping
    public Long createPublisherEntity(@Valid @RequestBody CreatePublisherDto createPublisherDto) {
        logger.info("Creating new publisherEntity");
        return publisherService.createPublisher(
                createPublisherDto.getName(),
                createPublisherDto.getCountry(),
                createPublisherDto.getNumberOfEmployees(),
                createPublisherDto.getFoundationYear()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePublisher(@PathVariable Long id) {
        logger.info("Deleting publisherEntity with id = " + id);
        try {
            publisherService.deletePublisher(id);
            return ResponseEntity.ok(null);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Publisher with id = " + id + " does not exist", HttpStatusCode.valueOf(400));
        }
    }

    @PutMapping
    public ResponseEntity<Object> updatePublisher(@Valid @RequestBody UpdatePublisherDto updatePublisherDto) {
        logger.info("Updating publisherEntity with id = " + updatePublisherDto.getId());
        try {
            return ResponseEntity.ok(publisherService.updatePublisher(
                    updatePublisherDto.getId(),
                    updatePublisherDto.getName(),
                    updatePublisherDto.getCountry(),
                    updatePublisherDto.getNumberOfEmployees(),
                    updatePublisherDto.getFoundationYear()
            ));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(400));
        }
    }
}
