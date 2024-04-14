package com.example.FP.service;

import com.example.FP.entity.*;
import com.example.FP.repository.MemberRepository;
import com.example.FP.repository.RecipeRepository;
import com.example.FP.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final WishListRepository wr;

    private final RecipeRepository rr;
    private final MemberRepository mr;

    public List<WishList> findAllWishList(String userid){
        return wr.findByUserid(userid);
    }





    //레시피목록 찜버튼 클릭   위시리스트추가
    public void addWish(Long id, long memberId) {
        Optional<Recipe> recipe =rr.findById(id);
        Recipe r=recipe.get();
        Optional<Member> member=mr.findById(memberId);
        Member  m = member.get();
        WishList wishList = new WishList(m,r);
        wr.save(wishList);
    }



    public List<WishList> findById(Long id, long memberId) {
    return wr.findByWishlistMemberIdAndWishlistRecipeId(memberId, id);
    }




}
