package com.realmadrid.service;

import com.realmadrid.model.Result;
import com.realmadrid.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    //save
    public Result save(Result result) {
        return resultRepository.save(result);

    }

    //get List
    public List<Result> findAll() {
        return resultRepository.findAll();
    }
}
