package com.realmadrid.service;

import com.realmadrid.model.Highlights;
import com.realmadrid.repository.HighlightsRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class HighlightsService {
    private final HighlightsRepository highlightsRepository;

    public HighlightsService(HighlightsRepository highlightsRepository) {
        this.highlightsRepository = highlightsRepository;
    }


    //save
    public Highlights saveHighlights(Highlights highlights) {
        if (highlightsRepository.findByDate(highlights.getDate()).isEmpty()) {
            return highlightsRepository.save(highlights);
        }
        return null;
    }

    //Get all
    public List<Highlights> findAllHighlights() {
        List<Highlights> highlights = highlightsRepository.findAll();
        Collections.reverse(highlights);
        return highlights;
    }

}
