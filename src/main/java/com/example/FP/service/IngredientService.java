package com.example.FP.service;

import com.example.FP.entity.Ingredient;
import com.example.FP.entity.Member;
import com.example.FP.repository.IngredientRepository;
import com.example.FP.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ir;
    private final MemberRepository mr;


    //재료 전체리스트 불러오기//
//    public List<Ingredient> list(){
        //재료 더미데이터 설정. 나중에 삭제
//        Ingredient ingredient = Ingredient.builder()
//                .ingredient_name("토마토")
//                .ingredient_price(9000)
//                .ingredient_origin("수원")
//                .ingredient_amount(99)
//                .ingredient_unit("g")
//                .ingredient_qty(90)
//                .build();
//
//        ir.save(ingredient);
        //맴버 더미데이터 설정. 나중에 지움.
//        Member member = Member.builder()
//                .addr("경기도수원")
//                .birth("19900909")
//                .email("tiger@naver.com")
//                .name("김순신")
//                .nickname("SS123")
//                .password("qweqweqwe123!@")
//                .phone("010-1234-5678")
//                .point(800)
//                .userid("qwe123")
//                .build();
//
//        mr.save(member);

//        return ir.findAll();
//
//    }

    //재료 목록 페이지네이션//

    //전체 재료목록 + 페이지네이션
    public Page<Ingredient> listAll(Pageable pageable){
        return ir.findAll(pageable);
    }

    //카테고리별 재료목록
    public Page<Ingredient> listByCategory(Long categoryId, Pageable pageable){
        return ir.findByCategoryId(categoryId, pageable);
    }

    public List<Ingredient> findAllByIngredientNameContaining(String keyword){
        return ir.findas(keyword);
    }

}
