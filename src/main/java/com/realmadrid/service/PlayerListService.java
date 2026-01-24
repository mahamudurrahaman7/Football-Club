package com.realmadrid.service;

import com.realmadrid.model.Player;
import com.realmadrid.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerListService {
    private final PlayerRepository playerRepository;

    public PlayerListService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player save(Player player) {
        if (playerRepository.findByPlayerId(player.getPlayerId()).isPresent()) {
            Player player1 = playerRepository.findByPlayerId(player.getPlayerId()).get();


            if (!player.getPlayerName().isEmpty()) {
                player1.setPlayerName(player.getPlayerName());
            }

            if (!player.getCountry().isEmpty()) {
                player1.setCountry(player.getCountry());
            }
            if(!player.getJerseyNumber().isEmpty()){
                player1.setJerseyNumber(player.getJerseyNumber());
            }

            if (!player.getFoot().isEmpty()) {
                player1.setFoot(player.getFoot());
            }

            if (player.getContractEnds() != null && !player.getContractEnds().isEmpty()) {
                player1.setContractEnds(player.getContractEnds());
            }

            if (player.getDateOfBirth()!= null && !player.getDateOfBirth().isEmpty()) {
                player1.setDateOfBirth(player.getDateOfBirth());
            }




            if(!player.getHeight().isEmpty()){
                player1.setHeight(player.getHeight());
            }
            if(!player.getWeight().isEmpty()){
                player1.setWeight(player.getWeight());
            }


            if( player.getInTheClubSince() != null && !player.getInTheClubSince().isEmpty()) {
                player1.setInTheClubSince(player.getInTheClubSince());
            }


            if(player.getGoals() != 0){
                player1.setGoals(player.getGoals());
            }


            if(!player.getImage().isEmpty()) {
                player1.setImage(player.getImage());
            }
            if(!player.getPosition().isEmpty()) {
                player1.setPosition(player.getPosition());
            }



            return playerRepository.save(player1);

        }
        return playerRepository.save(player);
    }


    //get all
    public List<Player> findAll() {
        List<Player> players = playerRepository.findAll();


        players.sort(Comparator.comparingInt(player -> {
            try {
                return Integer.parseInt(player.getJerseyNumber());
            } catch (NumberFormatException c) {
                return 25;
            }
        }));

        return players;
    }
    public Player findById(String  id) {
        return playerRepository.findById(id).get();
    }

    //delete player
    public void deletePlayer(String id) {
        playerRepository.deleteById(id);

    }
}
