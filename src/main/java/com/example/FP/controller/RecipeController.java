package com.example.FP.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class RecipeController {

    @GetMapping("/addRecipe")
    public String addRecipe(){
        return "/addRecipe";
    }

    @GetMapping("/detailRecipe")
    public String detailRecipe(){
        return "/detailRecipe";
    }

    @PostMapping(value="/uploadRecipeMainPhoto", produces = "application/json")
    @ResponseBody
    public String uploadRecipeMainPhoto(@RequestParam("file") MultipartFile multipartFile){
        JsonObject jsonObject = new JsonObject();

        String fileRoot = "src/main/resources/static/images/";	//저장될 외부 파일 경로
        String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자

        String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
        System.out.println(savedFileName);
        File targetFile = new File(fileRoot + originalFileName);

        try {
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
            jsonObject.addProperty("url", "../static/images/"+originalFileName);
            jsonObject.addProperty("responseCode", "success");
            System.out.println("저장완료");
        } catch (Exception e) {
            System.out.println("예외발생 : "+e.getMessage());
        }
        Gson gson = new Gson();
        return gson.toJson(jsonObject);
    }
}
