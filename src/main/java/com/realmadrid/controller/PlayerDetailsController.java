package com.realmadrid.controller;

import com.realmadrid.model.Player;
import com.realmadrid.service.PlayerListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PlayerDetailsController {
    private  final PlayerListService playerListService;

    public PlayerDetailsController(PlayerListService playerListService) {
        this.playerListService = playerListService;
    }

    @GetMapping("/player/{id}")
    public String viewPlayerDetails(@PathVariable("id") String id, Model model) {
        // Retrieve player details by id
        Player player = playerListService.findById(id);       // Assuming a method exists to find player by ID
        model.addAttribute("player", player);
        return "player-details";                            // The name of the view for the player details page
    }

}
