package com.example.FP.service;

import com.example.FP.entity.Ingredient;
import com.example.FP.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ir;


    public List<Ingredient> list(){
       return ir.findAll();
    }


}
