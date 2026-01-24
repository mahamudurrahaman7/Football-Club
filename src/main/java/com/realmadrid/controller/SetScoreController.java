package com.realmadrid.controller;

import com.realmadrid.dto.ScoreDto;
import com.realmadrid.model.Result;
import com.realmadrid.model.UpcomingMatches;
import com.realmadrid.service.ResultService;
import com.realmadrid.service.UpcomingMatchesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SetScoreController {
    private final UpcomingMatchesService upcomingMatchesService;
    private final ResultService resultService;

    public SetScoreController(UpcomingMatchesService upcomingMatchesService, ResultService resultService) {
        this.upcomingMatchesService = upcomingMatchesService;
        this.resultService = resultService;
    }


    @GetMapping("result-list")
    public String getResults(Model model){


        List<Result> resultList = resultService.findAll();  // results er list.....

        model.addAttribute("resultList", resultList);

        return "result-list";


    }


    @PostMapping("update-upcoming-match")
    public String updateUpcomingMatch(@RequestParam String id
            , Model model) {

        UpcomingMatches matches = upcomingMatchesService.findById(id);


        List<Result> resultList = resultService.findAll();  // results er list.....

        model.addAttribute("resultList", resultList);
        model.addAttribute("match", matches);
        model.addAttribute("dto", new ScoreDto());
        System.out.println(matches.getOpponentName());
        return "set-score";
    }
    @PostMapping("save-results")
    public String saveScore(@RequestParam String id,
                            @ModelAttribute ScoreDto dto,
                            Model model){
        UpcomingMatches matches = upcomingMatchesService.findById(id);
        Result result = new Result();
        result.setOurScore(dto.getOurScore());
        result.setTheirScore(dto.getTheirScore());
        result.setOpponentName(matches.getOpponentName());
        result.setVenueType(matches.getType());


        //save result ...delete upcoming match....
        Result result1 = resultService.save(result);
        if(result1 != null){
            upcomingMatchesService.deleteWithId(id);
        }

        List<Result> resultList = resultService.findAll();


        model.addAttribute("resultList", resultList);

        return "result-list";
    }

}
