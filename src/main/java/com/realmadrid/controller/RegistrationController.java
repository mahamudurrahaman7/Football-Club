package com.realmadrid.controller;

import com.realmadrid.dto.RegistrationDto;
import com.realmadrid.model.User;
import com.realmadrid.service.RegistrationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping("registration")
    public String registration(Model model, HttpSession session){


        model.addAttribute("dto", new RegistrationDto());
        return "registration";
    }

    @PostMapping("registration")
    public String saveRegistration(@ModelAttribute RegistrationDto dto,
                                   Model model, HttpSession session){

        String birthdate = "";
        String supportSince = "";
        if(dto.getSupportSince() != null){
            supportSince = dto.getSupportSince().toString();
        }
        if(dto.getBirthDate() != null){
            birthdate = dto.getBirthDate().toString();
        }

        List<String > roleList = new ArrayList<>();

        roleList.add("ROLE_USER");
//        roleList.add("ROLE_ADMIN");


        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setBirthday(birthdate);
        user.setSupportSince(supportSince);
        user.setCountry(dto.getCountry());
        user.setFavouritePlayer(dto.getFavouritePlayer());
        user.setRoleList(roleList);

        User user1  = registrationService.save(user);




        if(user1 == null){
            RegistrationDto registrationDto = new RegistrationDto();
            registrationDto.setAlreadyExists(true);

            model.addAttribute("dto", registrationDto);
            return "registration";  // jodi email already exist hoy....
        }
        session.setAttribute("loggedUser", user1);
        boolean isAdmin = registrationService.isAdmin(user1);
        session.setAttribute("isAdmin", isAdmin);




        model.addAttribute("dto", new RegistrationDto());
        model.addAttribute("isAdmin", isAdmin);
        model.addAttribute("user", user);

        return "dashboard";
    }



}
