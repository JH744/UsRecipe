package com.example.FP.service;

import com.example.FP.entity.*;
import com.example.FP.repository.MemberRepository;
import com.example.FP.repository.RecipeRepository;
import com.example.FP.repository.MemberRepository;
import com.example.FP.repository.RecipeRepository;
import com.example.FP.repository.WishListRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final WishListRepository wr;

    private final RecipeRepository rr;
    private final MemberRepository mr;
    private final MemberService ms;

    public List<WishList> findAllWishList(String userid){
        return wr.findByUserid(userid);
    }

    public void deleteWishlist(Long id){wr.deleteById(id);}


    //레시피목록 찜버튼 클릭   위시리스트추가
    public void addWish(Long id,HttpSession session) {
        Member m= ms.findById((String) session.getAttribute("userid"));
        Optional<Recipe> recipe =rr.findById(id);
        Recipe r=recipe.get();
        WishList wishList = new WishList(m,r);
        wr.save(wishList);
    }


    public List<WishList> findById(Long id, HttpSession session) {
        Member m= ms.findById((String) session.getAttribute("userid"));
        return wr.findByWishlistMemberIdAndWishlistRecipeId(m.getId(), id);
    }

    // 로그인회원id와 레시피id가 일치하는 위시리스트삭제.
    public void deleteWish(Long id,HttpSession session) {
        Member m= ms.findById((String) session.getAttribute("userid"));
        wr.deleteByMemberIdAndRecipeId(m.getId(),id);}



    //찜목록 top4  레시피가져옴
    public List<Object[]> getTopPopularRecipes() {
        return wr.findTopPopularRecipes(PageRequest.of(0, 4));
    }


}
