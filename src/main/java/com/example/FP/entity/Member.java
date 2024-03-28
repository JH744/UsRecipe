package com.example.FP.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Member {
    @Id@GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String userid;
    private String password;
    private String name;
    private String nickname;
    private String addr;
    private String email;
    private String phone;
    private int point;
    private String birth;
    @Enumerated(EnumType.STRING)
    private MemberRole role;


    @OneToMany(mappedBy = "inquiry_member")
    private List<Inquiry> inquiry_list = new ArrayList<>();
    @OneToMany(mappedBy = "wishlist_member")
    private List<WishList> wishlist_list = new ArrayList<>();

    @OneToMany(mappedBy = "recipe_member")
    private List<Recipe> recipe_list = new ArrayList<>();

    @OneToMany(mappedBy = "orders_member")
    private List<OrderDetails> order_member_list = new ArrayList<>();

    @OneToMany(mappedBy = "cart_member")
    private List<Cart> member_cart_list = new ArrayList<>();
    @OneToMany(mappedBy = "reply_member")
    private List<Reply> member_reply_list = new ArrayList<>();
}
