package com.realmadrid.controller;

import com.realmadrid.dto.TicketRequstDto;
import com.realmadrid.model.*;
import com.realmadrid.service.TicketRequestService;
import com.realmadrid.service.UpcomingMatchesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TicketBuyController {
    private final UpcomingMatchesService upcomingMatchesService;
    private final TicketRequestService ticketRequestService;

    public TicketBuyController(UpcomingMatchesService upcomingMatchesService, TicketRequestService ticketRequestService) {
        this.upcomingMatchesService = upcomingMatchesService;
        this.ticketRequestService = ticketRequestService;
    }

    @GetMapping("/ticket-buy")
    public String ticketBuy(@RequestParam String matchId,
                            @RequestParam String ticketType,
                            Model model) {


        UpcomingMatches upcomingMatches = upcomingMatchesService.findById(matchId);
        Ticket ticket = upcomingMatchesService.getSingleTicket(upcomingMatches, ticketType);


        model.addAttribute("ticket", ticket);
        model.addAttribute("match", upcomingMatches);
        model.addAttribute("dto", new TicketRequstDto());



        return "ticket-buy";
    }

    @PostMapping("/ticket-buy")
    public String ticketBuySave(@RequestParam String matchId, @RequestParam String ticketType
            ,@ModelAttribute TicketRequstDto dto,
                                Model model, HttpSession session){


        UpcomingMatches upcomingMatches = upcomingMatchesService.findById(matchId);
        Ticket ticket = upcomingMatchesService.getSingleTicket(upcomingMatches, ticketType);



        TicketRequst ticketRequst = new TicketRequst();
        ticketRequst.setTicket(ticket);
        User user1 = (User)session.getAttribute("loggedUser");
        if(user1 != null){
            ticketRequst.setUser(user1);
        }else{
            System.out.println("user is null");
        }

        System.out.println(user1.getCountry());
        ticketRequst.setTicketAmount(dto.getTicketAmount());
        ticketRequst.setMatches(upcomingMatches);
        ticketRequestService.save(ticketRequst);
        upcomingMatchesService.updateAvailableTicket(upcomingMatches, ticketType, dto.getTicketAmount());





        //notun dto baniye success true korechiii
        TicketRequstDto newDto = new TicketRequstDto();
//        newDto.setSuccess(true);

        model.addAttribute("match", upcomingMatches);
        model.addAttribute("ticket", ticket);
        model.addAttribute("dto", newDto);
        return "ticket-buy";
    }
}
