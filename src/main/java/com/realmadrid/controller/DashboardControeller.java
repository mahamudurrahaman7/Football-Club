package com.realmadrid.controller;

import com.realmadrid.model.Result;
import com.realmadrid.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardControeller {
    private final RegistrationService registrationService;
    private final PlayerListService playerListService;
    private final UpcomingMatchesService upcomingMatchesService;
    private final ResultService resultService;
    private final TicketRequestService ticketRequestService;

    public DashboardControeller(RegistrationService registrationService,
                                PlayerListService playerListService,
                                UpcomingMatchesService upcomingMatchesService,
                                ResultService resultService, TicketRequestService ticketRequestService) {
        this.registrationService = registrationService;
        this.playerListService = playerListService;
        this.upcomingMatchesService = upcomingMatchesService;
        this.resultService = resultService;
        this.ticketRequestService = ticketRequestService;
    }

    @GetMapping("dashboard")
    public String dashboard(Model model, HttpSession session) {

        long totalUser = registrationService.totalUsers();
        long totalTicketSell = ticketRequestService.totalTicketsSell();;


        model.addAttribute("totalUser", totalUser);
        model.addAttribute("isAdmin", session.getAttribute("isAdmin"));
        model.addAttribute("totalTicketSell", totalTicketSell);
        return "dashboard";

    }





}


