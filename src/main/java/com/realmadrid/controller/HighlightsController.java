package com.realmadrid.controller;

import com.realmadrid.dto.HighlightsDto;
import com.realmadrid.model.Highlights;
import com.realmadrid.service.HighlightsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HighlightsController {

    private final HighlightsService highlightsService;

    public HighlightsController(HighlightsService highlightsService) {
        this.highlightsService = highlightsService;
    }



    @GetMapping("highlights")
    public String highlights(Model model, HttpSession session) {
        List<Highlights> highlightsList = highlightsService.findAllHighlights();

        model.addAttribute("highlightsList", highlightsList);
        model.addAttribute("isAdmin", session.getAttribute("isAdmin"));
        model.addAttribute("dto", new HighlightsDto());
        return "highlights";
    }

    @PostMapping("highlights")
    public String postHighlights(@ModelAttribute HighlightsDto dto,
                                 Model model, HttpSession session){
        Highlights highlights = new Highlights();
        highlights.setTitle(dto.getTitle());
        highlights.setHighlightsId(dto.getHighlightsId());
        highlights.setVideo(dto.getVideo());
        if(dto.getDate() != null){
            String date = dto.getDate().toString();
            highlights.setDate(date);
        }

        Highlights highlights1 = highlightsService.saveHighlights(highlights);
        if(highlights1 == null){
            HighlightsDto highlightsDto = new HighlightsDto();
            highlightsDto.setIsPresent(true);
            model.addAttribute("dto", highlightsDto);

            List<Highlights> highlightsList = highlightsService.findAllHighlights();

            model.addAttribute("highlightsList", highlightsList);


            return "highlights";
        }

        HighlightsDto highlightsDto = new HighlightsDto();
        highlightsDto.setSavedSuccessfully(true);
        model.addAttribute("dto", highlightsDto);

        List<Highlights> highlightsList = highlightsService.findAllHighlights();

        model.addAttribute("highlightsList", highlightsList);
        model.addAttribute("isAdmin", session.getAttribute("isAdmin"));

        return "highlights";
    }
}
