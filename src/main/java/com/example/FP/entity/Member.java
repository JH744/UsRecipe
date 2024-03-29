package com.example.FP.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    @Column(nullable = false)
    private String userid;
    private String password;
    private String name;
    private String nickname;
    private String addr;
    private String email;
    private String phone;
    private Integer point;
    private String birth;
    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Builder.Default
    @OneToMany(mappedBy = "inquiry_member")
    private List<Inquiry> inquiry_list = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "wishlist_member")
    private List<WishList> wishlist_list = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "recipe_member")
    private List<Recipe> recipe_list = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "orders_member")
    private List<OrderDetails> order_member_list = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "cart_member")
    private List<Cart> member_cart_list = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "reply_member")
    private List<Reply> member_reply_list = new ArrayList<>();

    public Member(String userid, String password, String name, String nickname, String addr, String email, String phone, int point, String birth, MemberRole role, List<Inquiry> inquiry_list, List<WishList> wishlist_list, List<Recipe> recipe_list, List<OrderDetails> order_member_list, List<Cart> member_cart_list, List<Reply> member_reply_list) {
        this.userid = userid;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.addr = addr;
        this.email = email;
        this.phone = phone;
        this.point = point;
        this.birth = birth;
        this.role = role;
        this.inquiry_list = inquiry_list;
        this.wishlist_list = wishlist_list;
        this.recipe_list = recipe_list;
        this.order_member_list = order_member_list;
        this.member_cart_list = member_cart_list;
        this.member_reply_list = member_reply_list;
    }


}
