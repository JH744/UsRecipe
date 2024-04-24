package com.example.FP.dto;

import com.example.FP.entity.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class IngredientDto {

    private Long id;

    private String ingredient_name;
    private int ingredient_price;
    private String ingredient_origin;
    private String ingredient_amount;
    private String ingredient_unit;
    private int ingredient_qty;
    private String ingredient_image;
    private String ingredient_detail;

    private MultipartFile uploadFile;

    private IngredientCategory ingredient_ingredient_category;

}
