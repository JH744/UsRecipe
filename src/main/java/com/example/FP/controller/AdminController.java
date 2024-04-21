package com.example.FP.controller;

import com.example.FP.dto.IngredientDto;
import com.example.FP.dto.InquiryDto;
import com.example.FP.entity.*;
import com.example.FP.mapper.InquiryMapper;
import com.example.FP.repository.IngredientCategoryRepository;
import com.example.FP.service.*;
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

    private final OrdersService os;
    private final NoticeService ns;
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
    public String adminInquiryDetailSubmit(@RequestParam Long id,String inquiryAnswer){

        is.updateInquiry(id,inquiryAnswer);

        return "redirect:/admin/inquiry";

    }

    @GetMapping("/deleteInquiry/{id}")
    public String deleteInquiry(@PathVariable Long id){
        is.deleteInquiry(id);


        return "redirect:/admin/inquiry";
    }
    @GetMapping("/notice")
    public String listNotice(Model model){
        model.addAttribute("list",ns.findAll());
        return "/admin/adminNoticeList";

    }

    @GetMapping("/addIngredient")
    public String addIngredientForm(Model model){
        model.addAttribute("list",igs.findAllIngredientCategory());
        return "/admin/adminInsertIngredient";
    }
    @GetMapping("/ingredient")
    public String ingredientList(Model model){
        model.addAttribute("list",igs.findAll());
        return "/admin/adminIngredientList";
    }


    @PostMapping("/addIngredient")
    public String addIngredientForm(IngredientDto ingredientDto, HttpServletRequest request){


        MultipartFile uploadFile = ingredientDto.getUploadFile();
        String path = "C:\\FP\\src\\main\\resources\\webapp\\ingredientImages";
        System.out.println("경로 : " + path);
        String fname = uploadFile.getOriginalFilename();
        System.out.println("파일명 : " + fname);
        Long categoryId = ingredientDto.getIngredient_ingredient_category().getId();

        // ID를 사용하여 영속성 컨텍스트에 해당하는 IngredientCategory 엔티티를 로드
        IngredientCategory category = ir.findById(categoryId).orElse(null);

        if (category != null) {
            // 올바른 IngredientCategory를 설정
            ingredientDto.setIngredient_ingredient_category(category);
        } else {

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


        igs.save(ingredientDto);
        return "redirect:/admin/ingredient";

    }

    @GetMapping("/orders/{state}")
    public String ordersList(Model model,@PathVariable String state){
        System.out.println("전송받은 데이터 : " + state);
        if(state.equals("all")){
            model.addAttribute("list",os.findAll());
        }

        model.addAttribute("list",os.findByOrderState(state));


        return "/admin/adminOrdersList";
    }

    @GetMapping("/recipe")
    public String recipeList(Model model){


        return "/admin/adminRecipeList";
    }
    @GetMapping("/cancelOrder/{id}")
    public String cancelOrder(@PathVariable Long id){
        os.changeState(id);
        return "redirect:/adminOrderList";


    }


}
