package com.realmadrid.repository;

import com.realmadrid.model.UpcomingMatches;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UpcomingMatchesRepository extends MongoRepository<UpcomingMatches, String > {

    Optional<UpcomingMatches> findById(String id);

}
