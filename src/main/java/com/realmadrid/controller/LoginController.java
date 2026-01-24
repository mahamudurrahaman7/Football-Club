package com.realmadrid.controller;

import com.realmadrid.dto.LoginDto;
import com.realmadrid.model.LoggedUser;
import com.realmadrid.model.User;
import com.realmadrid.service.RegistrationService;
import com.realmadrid.service.TicketRequestService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private final RegistrationService registrationService;
    private final TicketRequestService ticketRequestService;

    public LoginController(RegistrationService registrationService, TicketRequestService ticketRequestService) {
        this.registrationService = registrationService;
        this.ticketRequestService = ticketRequestService;
    }

    @GetMapping("login")
    public String login(Model model,
                        HttpSession session) {


        model.addAttribute("dto", new LoginDto());
        return "login";
    }

    @PostMapping("login")
    public String checkLogin(@ModelAttribute LoginDto dto, Model model,
                             HttpSession session){
        User user = registrationService.findWithEmail(dto.getEmail());
        if(user == null){
            LoginDto loginDto = new LoginDto();
            loginDto.setFailure(true);
            model.addAttribute("dto", loginDto);
            return "login";

        }
        if(user.getPassword().equals(dto.getPassword())){

            session.setAttribute("loggedUser", user);
            boolean isAdmin = registrationService.isAdmin(user);
            session.setAttribute("isAdmin", isAdmin);


            long totalUser = registrationService.totalUsers();
            long totalTicketSell = ticketRequestService.totalTicketsSell();;


            model.addAttribute("totalUser", totalUser);
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("totalTicketSell", totalTicketSell);
            return "dashboard";

        }
        else{
            LoginDto loginDto = new LoginDto();
            loginDto.setFailure(true);
            model.addAttribute("dto", loginDto);
            return "login";
        }


    }
    @PostMapping("logout")
    public String logout(HttpSession session, Model model){

        session.invalidate();

        model.addAttribute("dto", new LoginDto());
        return "login";
    }



}
