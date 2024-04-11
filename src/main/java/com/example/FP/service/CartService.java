package com.example.FP.service;

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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cp;

    private final IngredientRepository ir;

    private final MemberRepository mr;


    public void addCart(Long id, long memberId) {
        // ingredient 객체와 member 객체를 cart에 저장
       Optional<Ingredient> ingredient =ir.findById(id);
       Ingredient i=ingredient.get();
       Optional<Member> member=mr.findById(memberId);
       Member  m = member.get();
       Cart cart = new Cart(m,null,i);
       cp.save(cart);
    }


//    public List<Cart> listCart(long id){
//
//
//
//   }






}
