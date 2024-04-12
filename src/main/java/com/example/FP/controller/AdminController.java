package com.example.FP.controller;

import com.example.FP.dto.IngredientDto;
import com.example.FP.dto.InquiryDto;
import com.example.FP.entity.Ingredient;
import com.example.FP.entity.IngredientCategory;
import com.example.FP.entity.Inquiry;
import com.example.FP.entity.InquiryState;
import com.example.FP.mapper.InquiryMapper;
import com.example.FP.repository.IngredientCategoryRepository;
import com.example.FP.service.IngredientService;
import com.example.FP.service.InquiryService;
import com.example.FP.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.net.http.HttpRequest;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final MemberService ms;
    private final InquiryService is;
    private final IngredientService igs;
    private final IngredientCategoryRepository ir;

    @GetMapping("/member")
    public String adminMemberForm(Model model){
        model.addAttribute("list",ms.findAllMember());
        return "/admin/adminMember";


    }
    @GetMapping("/inquiry")
    public String adminInquiryForm(Model model){
        model.addAttribute("answered",is.answered());
        model.addAttribute("yet",is.answeredYet());

        return"/admin/adminInquiry";
    }
    @GetMapping("/inquiryDetail/{id}")
    public String adminInquiryDetailForm(Model model, @PathVariable Long id){


        model.addAttribute("list",is.listById(id));

        return "/admin/adminInquiryDetail";
    }

    @PostMapping("/inquiryDetail")
    public String adminInquiryDetailSubmit(@RequestParam Long id){

        is.updateInquiry(id);

        return "redirect:/admin/inquiry";

    }

    @GetMapping("/deleteInquiry/{id}")
    public String deleteInquiry(@PathVariable Long id){
        is.deleteInquiry(id);

        return "redirect:/admin/inquiry";
    }

    @GetMapping("/addIngredient")
    public String addIngredientForm(Model model){
        model.addAttribute("list",igs.findAllIngredientCategory());
        return "/admin/adminInsertIngredient";
    }

    @PostMapping("/addIngredient")
    public String addIngredientForm(IngredientDto ingredientDto, HttpServletRequest request){


        MultipartFile uploadFile = ingredientDto.getUploadFile();
        String path = "C:\\FP\\src\\main\\resources\\static\\images";
        System.out.println("경로 : " + path);
        String fname = uploadFile.getOriginalFilename();
        System.out.println("파일명 : " + fname);
        Long categoryId = ingredientDto.getIngredient_ingredient_category().getId();

        // ID를 사용하여 영속성 컨텍스트에 해당하는 IngredientCategory 엔티티를 로드합니다.
        IngredientCategory category = ir.findById(categoryId).orElse(null);

        if (category != null) {
            // 올바른 IngredientCategory를 설정합니다.
            ingredientDto.setIngredient_ingredient_category(category);

            // Ingredient 엔티티를 저장합니다.
            igs.save(ingredientDto);
        } else {
            // 오류 처리
        }
        if(uploadFile!=null && !uploadFile.isEmpty()){
            try{
                byte[] fileData = uploadFile.getBytes();
                FileOutputStream fos = new FileOutputStream(path+"/"+fname);
                fos.write(fileData);
                fos.close();
                ingredientDto.setIngredient_image(fname);

            }catch (Exception e){
                System.out.println("재료 이미지 등록 실패  : " + e.getMessage());
            }
        }

//        igs.save(new Ingredient(ingredientDto.getIngredient_name(),ingredientDto.getIngredient_price(),ingredientDto.getIngredient_origin(),ingredientDto.getIngredient_amount(),ingredientDto.getIngredient_unit(),ingredientDto.getIngredient_qty(),ingredientDto.getIngredient_image(),ingredientDto.getIngredient_detail(),ingredientDto.getIngredient_ingredient_category()));

        igs.save(ingredientDto);
        return "redirect:/admin/adminMember";

    }


}
