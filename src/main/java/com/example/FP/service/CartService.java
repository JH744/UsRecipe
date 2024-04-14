package com.example.FP.service;

import com.example.FP.dto.CartIngredientDto;
import com.example.FP.entity.Cart;
import com.example.FP.entity.Ingredient;
import com.example.FP.entity.Member;
import com.example.FP.repository.CartRepository;
import com.example.FP.repository.IngredientRepository;
import com.example.FP.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cr;

    private final IngredientRepository ir;

    private final MemberRepository mr;


    //재료목록창에서  담기 클릭  장바구니 추가
    public void addCart(Long id, long memberId) {
        // ingredient 객체와 member 객체를 cart에 저장
       Optional<Ingredient> ingredient =ir.findById(id);
       Ingredient i=ingredient.get();
       Optional<Member> member=mr.findById(memberId);
       Member  m = member.get();
       Cart cart = new Cart(m,null,i);
       cr.save(cart);
    }

    //장바구니에 들어있는지 여부 확인
    public List<Cart> findById(Long id, long memberId){
        List<Cart> list =  cr.findByCartMemberIdAndCartIngredientId(memberId,id);
        System.out.println("찾아온 카트 : "+ list);
       return list;
    }


    // 장바구니 리스트
    @Transactional(readOnly = true)
    public List<CartIngredientDto> listCart(Long memberId) {
        return cr.findCartIngredientsByMemberId(memberId);
    }

    //상품명과 로그인된id를 조회해 일치하는 장바구니 항목을 삭제함
    public void deleteCart(List<String> ingredientNames, long memberId) {
            for( String ingredientName : ingredientNames){
                cr.deleteByMemberIdAndIngredientName(memberId,ingredientName);
            }
    }



}
