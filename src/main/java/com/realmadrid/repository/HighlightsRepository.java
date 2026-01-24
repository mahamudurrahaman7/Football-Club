package com.realmadrid.repository;

import com.realmadrid.model.Highlights;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HighlightsRepository extends MongoRepository<Highlights, String> {
    Optional<Highlights> findByHighlightsId(String highlightsId);
    Optional<Highlights> findById(String id);
    Optional<Highlights> findByDate(String date);

}
