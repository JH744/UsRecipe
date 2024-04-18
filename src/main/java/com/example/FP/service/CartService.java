package com.example.FP.service;

import com.example.FP.dto.CartDto;
import com.example.FP.entity.Cart;
import com.example.FP.entity.Ingredient;
import com.example.FP.entity.Member;
import com.example.FP.repository.CartRepository;
import com.example.FP.repository.IngredientRepository;
import com.example.FP.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    @Autowired
    private final CartRepository cp;

    private final MemberRepository mr;
    private final IngredientRepository ir;


    public void insertCart(String userid, Long ingredientId){
        Member member = mr.findByUserid(userid);
        Ingredient ingredient = ir.findById(ingredientId).get();

        Cart cart = new Cart(member,ingredient);
        cp.save(cart);
    }

//    public List<Cart> listCart(long id){
//
//
//
//   }






}
