package com.realmadrid.controller;

import com.realmadrid.dto.UpcomingMatchesDto;

import com.realmadrid.model.UpcomingMatches;
import com.realmadrid.service.UpcomingMatchesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
public class UpcomingMatchesController {
    private final UpcomingMatchesService upcomingMatchesService;

    public UpcomingMatchesController(UpcomingMatchesService upcomingMatchesService) {
        this.upcomingMatchesService = upcomingMatchesService;
    }


    @GetMapping("/upcoming-matches")
    public String fixureResult(Model model, HttpSession session) {




        UpcomingMatchesDto matches = new UpcomingMatchesDto();

        matches.setTickets(new ArrayList<>());
        model.addAttribute("matches", matches);


        List<UpcomingMatches> upcomingMatchesList = upcomingMatchesService.findAll();
        model.addAttribute("upcomingMatchesList", upcomingMatchesList);
        model.addAttribute("isAdmin", session.getAttribute("isAdmin"));

        return "upcoming-matches";
    }


    @PostMapping("upcoming-matches")
    public String saveFixure(@ModelAttribute UpcomingMatchesDto dto,


                             Model model, HttpSession session) {

        UpcomingMatches fixure = new UpcomingMatches();
        fixure.setOpponentName(dto.getOpponentName());
        fixure.setTournamentName(dto.getTournamentName());
        fixure.setType(dto.getType());  //Match type home or away



        if(dto.getDate()!= null){
            String date = dto.getDate().toString();
            fixure.setDate(date);
        }

        if(dto.getTime() != null){
            String time = dto.getTime().toString();
            fixure.setTime(time);
        }

        if (dto.getTickets() != null) {
            fixure.setTickets(dto.getTickets());
        }


        UpcomingMatches fixure1 = upcomingMatchesService.save(fixure);

        model.addAttribute("savedMatch", fixure1);









        UpcomingMatchesDto matches = new UpcomingMatchesDto();
        matches.setTickets(new ArrayList<>());
        model.addAttribute("matches", matches);


        List<UpcomingMatches> upcomingMatchesList = upcomingMatchesService.findAll();
        model.addAttribute("upcomingMatchesList", upcomingMatchesList);
        model.addAttribute("isAdmin", session.getAttribute("isAdmin"));


        return "redirect:/upcoming-matches";




    }

    @PostMapping("delete-upcoming-match")
    public String deleteMatch(@RequestParam String id, Model model ){
        upcomingMatchesService.deleteWithId(id);

        UpcomingMatchesDto matches = new UpcomingMatchesDto();
        matches.setTickets(new ArrayList<>());
        model.addAttribute("matches", matches);


        List<UpcomingMatches> upcomingMatchesList = upcomingMatchesService.findAll();
        model.addAttribute("upcomingMatchesList", upcomingMatchesList);



        return "upcoming-matches";
    }
}
