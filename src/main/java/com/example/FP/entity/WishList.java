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
    private Member wishlist_member;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe wishlist_recipe;

    public WishList(Member wishlist_member, Recipe wishlist_recipe) {
        this.wishlist_member = wishlist_member;
        this.wishlist_recipe = wishlist_recipe;
    }

    public static WishList createCart(Recipe recipe,Member member){
        WishList wishList = new WishList(member,recipe);
        return wishList;
    }
}
