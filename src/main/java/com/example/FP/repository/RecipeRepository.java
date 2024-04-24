package com.example.FP.repository;

import com.example.FP.entity.Ingredient;
import com.example.FP.entity.Member;
import com.example.FP.entity.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    Page<Recipe> findPageBy(Pageable page);

    List<Recipe> findTop4ByOrderByRecipeViewsDesc();

    @Query(value = "select IFNULL(max(recipe_id),0)+1 from recipe", nativeQuery = true)
    Long nextRecipeId();

    @Modifying
    @Query(value = "update recipe set recipe_views = recipe_views+1 where recipe_Id=:recipeId",nativeQuery = true)
    void UpdateRecipeViews(@Param("recipeId") Long recipeId);

//    Recipe findById();

    // 가장 조회수가 높은 회원 그룹
    @Query("SELECT r.recipeMember FROM Recipe r GROUP BY r.recipeMember ORDER BY SUM(r.recipeViews) DESC")
    List<Member> findMember();


  // 레시피목록 : 키워드 검색 + 카테고리 + 페이징

    @Query("SELECT r FROM Recipe r WHERE " +
            "(:keyword IS NULL OR r.recipeTitle LIKE %:keyword%) AND " +
            "(:categoryId IS NULL OR r.recipeCategory.id = :categoryId)")
    Page<Recipe> findByTitleContainingAndCategory(
            @Param("keyword") String keyword,
            @Param("categoryId") Long categoryId,
            Pageable pageable);

    //레시피목록 : 전체 불러오기 + 키워드 검색 + 페이징
    @Query("SELECT r FROM Recipe r WHERE " +
            "(:keyword IS NULL OR r.recipeTitle LIKE %:keyword%)")
    Page<Recipe> findByTitleContaining(@Param("keyword") String keyword, Pageable pageable);


    //찜목록 top4의 id를 전달해 일치하는 리스트를 가져옴
    List<Recipe> findByIdIn(List<Long> ids);

    // 레시피목록 : 키워드 검색 + 카테고리 + 페이징 + 맴버id
    @Query("SELECT r FROM Recipe r WHERE " +
            "(:keyword IS NULL OR r.recipeTitle LIKE %:keyword%) AND " +
            "(:categoryId IS NULL OR r.recipeCategory.id = :categoryId) AND"+
            "(:memberId IS NULL OR r.recipeMember.id = :memberId)")
    Page<Recipe> findByTitleContainingAndCategoryAndMemberId(
            @Param("keyword") String keyword,
            @Param("categoryId") Long categoryId,
            @Param("memberId") Long memberId,
            Pageable pageable);

}
