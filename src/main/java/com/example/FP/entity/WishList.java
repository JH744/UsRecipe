package com.example.FP.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wishlist")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WishList {
    @Id@GeneratedValue
    @Column(name = "wishlist_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member wishlistMember;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe wishlistRecipe;

    public WishList(Member wishlistMember, Recipe wishlistRecipe) {
        this.wishlistMember = wishlistMember;
        this.wishlistRecipe = wishlistRecipe;
    }

    public static WishList createCart(Recipe recipe,Member member){
        WishList wishList = new WishList(member,recipe);
        return wishList;
    }
}
