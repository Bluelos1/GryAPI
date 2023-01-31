package com.example.gryapi.db.repository;

import com.example.gryapi.db.model.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherEntity,Long> {
}
