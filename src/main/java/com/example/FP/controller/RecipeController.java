package com.example.FP.controller;


import com.example.FP.entity.Recipe;
import com.example.FP.service.MemberService;
import com.example.FP.service.RecipeCategoryService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import com.example.FP.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.*;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService rs;
    private final MemberService ms;
    private final RecipeCategoryService rc;

    @GetMapping("/listRecipe/{page}")
    public String recipeList(@PathVariable("page") int page, Model model,
                             @RequestParam(required = false ) Long category,
                             @RequestParam(required = false ) String sortBy,
                             @RequestParam(required = false ) String direction,
                             @RequestParam(required = false ) String keyword,
                             @RequestParam(required = false ) Long member_id,
                             HttpSession session){

        System.out.println("전달받은 검색어:"+ keyword);

        // **정렬 및 카테고리 상태유지** //
        //category에 null이 아닌 새값이 전달된 경우 세션에 새롭게 저장.
        if(category != null) {
            session.setAttribute("category", category);
        }else {
            //category가 null이라면 기존session에서 값을 가져옴
            category= (Long) session.getAttribute("category");
        }

        //sort에 null이 아닌 새값이 전달된 경우 세션에 새롭게 저장.
        if(sortBy != null) {
            session.setAttribute("sort", sortBy);
            System.out.println("sortBy저장됨");
            System.out.println(session.getAttribute("sort"));
            session.setAttribute("direction", direction);
            System.out.println("direction저장됨");
            System.out.println(session.getAttribute("direction"));
        }else {
            //sort가 null이면 기존session에서 값을 가져옴
            sortBy = (String) session.getAttribute("sort");
            direction = (String) session.getAttribute("direction");
        }


        //***정렬조건 유무 >>  로직 설정***//
        Pageable pageable;
        if (sortBy != null && !sortBy.isEmpty()) {  //정렬조건이 넘어 올 경우
            Sort.Direction Direction = (direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC );
            pageable = PageRequest.of(page-1, 8, Direction, sortBy);
            System.out.println("소트 뽑아봄");
            System.out.println(sortBy);
            System.out.println(pageable.getSort());
        } else {  // 정렬 방향이 지정되지 않았을 경우 기본값 사용
            pageable = PageRequest.of(page-1, 8);
        }



        Page<Recipe>  list =null;
        int totalPage = 0;
        //카테고리가 전체보기(000)이라면 모든 목록 불러오기
        if(category == null || category == 000) {
             list = rs.listAll(pageable, keyword);
            totalPage = list.getTotalPages();
        }
        //카테고리가 전체보기(000)이 아니라면 카테고리 목록 불러오기
        else if(category != 000) {
            list = rs.listRecipes(keyword, category, pageable);
            totalPage = list.getTotalPages();
        }

        if (member_id != null) {
            System.out.println("아이디 들어옴");
            list = rs.listRecipes(keyword, category, member_id,pageable);
            totalPage = list.getTotalPages();
            for (Recipe l: list) {
                System.out.println(l.getRecipeTitle());
            }
        }

        model.addAttribute("list", list);
        model.addAttribute("totalPage", totalPage);




        //이 레시피는 어때요?
        long HowAboutToday ;
        List<Recipe> r_list = rs.randomList();
        if (r_list != null && !r_list.isEmpty()) {
            System.out.println(rs.randomList().get(0).getRecipeTitle() + " 레피시 추천");
            model.addAttribute("HowAbout", r_list.get(0));
        } else {
            model.addAttribute("HowAbout", null);
        }


        //주간인기레시피
        //찜목록 top4를 불러옴
        List<Recipe> listTop4 = rs.listTop4();
        for (Recipe ls4: listTop4) {
            System.out.println("랭킹4");
            System.out.println(ls4);
        }
        model.addAttribute("listTop4", listTop4);
        return "/all/recipe";
    }

    //레시피 등록 화면으로 이동
    @GetMapping("/addRecipe")
    public String addRecipe(Model model, HttpSession session){
        String role = ms.findById(session.getAttribute("userid")+"").getRole().name();
        model.addAttribute("role",role);
        model.addAttribute("recipe_category",rc.findAllRecipeCategory());

        return "/user/addRecipe";
    }

    //레시피 내부에서 사진 저장용
    @PostMapping(value="/uploadRecipePhoto", produces = "application/json")
    @ResponseBody
    public String uploadRecipeMainPhoto(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request){
        JsonObject jsonObject = new JsonObject();
//        String fileRoot = "src/main/resources/static/images/";	//저장될 외부 파일 경로
        String fileRoot = request.getServletContext().getRealPath("/recipeImages");	//저장될 외부 파일 경로
        String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자

        String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
        File targetFile = new File(fileRoot+"/"+ savedFileName);

        try {
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
            jsonObject.addProperty("url", savedFileName);
            jsonObject.addProperty("responseCode", "success");
        } catch (Exception e) {
            System.out.println("예외발생 : "+e.getMessage());
            jsonObject.addProperty("responseCode", "error");
        }
        Gson gson = new Gson();
        return gson.toJson(jsonObject);
    }

    //레시피 사진 변경이 삭제용
    @PostMapping(value="/deleteRecipePhoto", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public void deleteRecipePhoto(@RequestBody Map<String,Object> deleteFileNameList, HttpServletRequest request){
        String fileRoot = request.getServletContext().getRealPath("/recipeImages");	//저장될 외부 파일 경로
        List<String> FileNameList = (List<String>) deleteFileNameList.get("deleteFileNameList");
        try {
            for(String photoName : FileNameList){
                File file = new File(fileRoot+"/"+photoName);
                System.out.println(photoName);
                file.delete();
            }
        } catch (Exception e) {
            System.out.println("예외발생 : "+e.getMessage());
        }
    }

    //레시피 등록
    @PostMapping("/saveRecipe")
    @ResponseBody
        public String insertRecipe(@RequestParam Map<String, Object> recipeDataList,HttpSession session){
        Long recipeId = rs.saveRecipe(recipeDataList,session.getAttribute("userid").toString());
        return "/detailRecipe?recipeNum="+recipeId;
    }

    //레시피 상세 detailRecipe?recipeNum=값
    @GetMapping("/detailRecipe")
    public String detailRecipe(@RequestParam String recipeNum,Model model){
        Long id = Long.parseLong(recipeNum);
        Recipe recipe = rs.detailRecipe(id);

        model.addAttribute("recipe",recipe);
        model.addAttribute("writer",recipe.getRecipeMember().getNickname());
        return "/all/detailRecipe";
    }

    //레시피 수정 updateRecipe?recipeId=값
    @GetMapping("/updateRecipe")
    public String updateRecipe(@RequestParam Long recipeId,Model model,HttpSession session) {
        Recipe recipe = rs.detailRecipe(recipeId);
        String view = "404";
        if (recipe.getRecipeMember().getUserid().equals((String) session.getAttribute("userid"))) {
            model.addAttribute("recipe", rs.detailRecipe(recipeId));
            model.addAttribute("recipe_category", rc.findAllRecipeCategory());
            view = "/user/updateRecipe";
        }
        return view;
    }

    
    //유저가 본인 레시피 삭제
    @GetMapping("/deleteRecipe")
    public String deleteRecipe(@RequestParam Long recipeId,HttpSession session){
        String view = "404";
        Recipe recipe = rs.detailRecipe(recipeId);
        if (recipe.getRecipeMember().getUserid().equals((String) session.getAttribute("userid"))) {
            rs.deleteRecipe(recipeId);
            view = "redirect:/all/listRecipe/1";
        }
        return view;
    }
}
