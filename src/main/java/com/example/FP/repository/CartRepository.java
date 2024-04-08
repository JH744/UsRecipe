package com.example.FP.repository;

import com.example.FP.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {

//
//    @Query("SELECT c, r.title, i.price FROM Cart c JOIN c.cart_recipe r JOIN c.cart_ingredient i WHERE c.cart_member.id = :memberId")
//    List<Object[]> findCartDetailsByMemberId(Long memberId);

}
