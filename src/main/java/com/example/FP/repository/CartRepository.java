package com.example.FP.repository;

import com.example.FP.dto.CartIngredientDto;
import com.example.FP.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long>, CartRepositoryCustom {



    @Query("SELECT new com.example.FP.dto.CartIngredientDto(i.ingredientName, i.ingredientPrice, COUNT(i)) " +
            "FROM Cart c JOIN c.cartIngredient i " +
            "WHERE c.cartMember.id = :memberId " +
            "GROUP BY i.ingredientName, i.ingredientPrice")
    List<CartIngredientDto> findCartIngredientsByMemberId(@Param("memberId") Long memberId);



    List<Cart> findByCartMemberIdAndCartIngredientId(Long memberId, Long ingredientId);



    @Modifying
    @Transactional
    @Query("DELETE FROM Cart c WHERE c.cartMember.id = :memberId AND c.cartIngredient.ingredientName = :ingredientName")
    void deleteByMemberIdAndIngredientName(Long memberId, String ingredientName);





}
