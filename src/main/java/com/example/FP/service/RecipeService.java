package com.example.FP.service;

import com.example.FP.entity.Recipe;
import com.example.FP.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {


    private final RecipeRepository rr;


    public List<Recipe> list(){
        return rr.findAll();
    }public Optional<Recipe> HowAbout(Long id){
        return rr.findById(id);
    }



}
