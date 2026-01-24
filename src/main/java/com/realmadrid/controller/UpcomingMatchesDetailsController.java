package com.realmadrid.controller;

import com.realmadrid.model.UpcomingMatches;
import com.realmadrid.service.UpcomingMatchesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpcomingMatchesDetailsController {
    private final UpcomingMatchesService upcomingMatchesService;

    public UpcomingMatchesDetailsController(UpcomingMatchesService upcomingMatchesService) {
        this.upcomingMatchesService = upcomingMatchesService;
    }

    @GetMapping("/match/{id}")
    public String showSelectedMatches(@PathVariable("id") String id, Model model) {

        UpcomingMatches upcomingMatches = upcomingMatchesService.findById(id);

        model.addAttribute("upcomingMatches", upcomingMatches);

        return "upcoming-matches-details";

    }


}
