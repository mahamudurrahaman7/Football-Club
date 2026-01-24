package com.realmadrid.controller;

import com.realmadrid.dto.PlayerListDto;
import com.realmadrid.model.Player;
import com.realmadrid.service.PlayerListService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class PlayerListController {

    public String uploadDirectory = "src/main/resources/static/img";

    private final PlayerListService playerListService;

    public PlayerListController(PlayerListService playerListService) {
        this.playerListService = playerListService;
    }

    @GetMapping("player-list")
    public String playerList(Model model, HttpSession session) {
        List<Player> playerList = playerListService.findAll();

        model.addAttribute("playerList", playerList);
        model.addAttribute("isAdmin", session.getAttribute("isAdmin"));

        model.addAttribute("dto",new PlayerListDto());
        return "player-list";
    }


    @PostMapping("player-list")
    public String addNewPlayer(@ModelAttribute PlayerListDto dto, Model model,
                               @RequestParam("productImage") MultipartFile file,
                               @RequestParam("image") String imgName, HttpSession session)throws IOException {
        Player player = new Player();
        player.setPlayerId(dto.getPlayerId());
        player.setPlayerName(dto.getPlayerName());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setHeight(dto.getHeight());
        player.setWeight(dto.getWeight());

        player.setCountry(dto.getCountry());
        if (dto.getGoals() != null && !dto.getGoals().isEmpty()) {
            player.setGoals(Integer.parseInt(dto.getGoals()));
        }
        else if (dto.getGoals() == null) {
            player.setGoals(0);
        }
        player.setFoot(dto.getFoot());
//        player.setImage(dto.getImage());
        String image;

        if(!file.isEmpty()) {
            image = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDirectory, image);
            Files.write(fileNameAndPath, file.getBytes());
        }
        else {
            image = imgName;
        }

        player.setImage(image);


        player.setPosition(dto.getPosition());

        if(dto.getContractEnds() != null){
            String contractEnd = dto.getContractEnds().toString();
            player.setContractEnds(contractEnd);
        }

        if(dto.getDateOfBirth() != null){
            String birth = dto.getDateOfBirth().toString();
            player.setDateOfBirth(birth);
        }

        if(dto.getInTheClubSince() != null){
            String inTheClub = dto.getInTheClubSince().toString();
            player.setInTheClubSince(inTheClub);
        }

        Player player1 = playerListService.save(player);

        model.addAttribute("recentSavedPlayer",player1);
        model.addAttribute("dto",new PlayerListDto());
        List<Player> playerList = playerListService.findAll();

        model.addAttribute("playerList", playerList);
        model.addAttribute("isAdmin", session.getAttribute("isAdmin"));

        //list return kora lagbe....
        return "player-list";
    }

    @PostMapping("delete-player")
    public String deletePlayer(@RequestParam String id, Model model, HttpSession session) {
        PlayerListDto playerListDto = new PlayerListDto();
        playerListService.deletePlayer(id);
        playerListDto.setDeleted(true);


        model.addAttribute("dto", playerListDto);

        List<Player> playerList = playerListService.findAll();

        model.addAttribute("playerList", playerList);
        model.addAttribute("isAdmin", session.getAttribute("isAdmin"));

        return "player-list";
    }
}
