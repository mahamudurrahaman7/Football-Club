package com.realmadrid.repository;

import com.realmadrid.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
    Optional<Player> findByPlayerId(String playerId);

    boolean deleteByPlayerId(String playerId);

}
