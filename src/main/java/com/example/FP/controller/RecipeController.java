package com.example.FP.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;
import com.example.FP.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService rs;

    @GetMapping("/recipe")
    public String recipeList(Model model){

        //레시피목록 불러오기
        model.addAttribute("list",rs.list());

        //이 레시피는 어때요?
        long HowAboutToday ;
        //위 번호는 난수로 설정 (범위는 총 레시피수)
        //model.addAttribute("HowAbout",rs.HowAbout(sd));


        //주간인기레시피
        // 찜목록 중에서 레시피id를 count했을 시 가장 많은 top4를 불러옴

        return "recipe";
    }


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
        System.out.println(multipartFile);
        String fileRoot = "src/main/resources/static/images/";	//저장될 외부 파일 경로
        String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자

        String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
        System.out.println(savedFileName);
        File targetFile = new File(fileRoot + savedFileName);

        try {
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
//            jsonObject.addProperty("url", "../static/images/"+savedFileName);
            jsonObject.addProperty("url", multipartFile.getBytes().toString());
            jsonObject.addProperty("imgName", savedFileName);
            jsonObject.addProperty("responseCode", "success");
        } catch (Exception e) {
            System.out.println("예외발생 : "+e.getMessage());
            jsonObject.addProperty("responseCode", "error");
        }
        Gson gson = new Gson();
        return gson.toJson(jsonObject);
    }
}
