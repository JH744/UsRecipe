package com.example.FP.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "wishlist")
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
}
