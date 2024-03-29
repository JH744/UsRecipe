package com.example.FP.dto;

import com.example.FP.entity.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class MemberDto {

    private Long id;

    @Size(max = 12,min = 6 ,message = "아이디는 6~12자 사이여야합니다.")
    private String userid;
    private String password;
    private String name;
    private String nickname;
    private String addr;
    private String email;
    private String phone;
    private int point;
    private String birth;

    private MemberRole role;



    private List<Inquiry> inquiry_list = new ArrayList<>();

    private List<WishList> wishlist_list = new ArrayList<>();


    private List<Recipe> recipe_list = new ArrayList<>();


    private List<OrderDetails> order_member_list = new ArrayList<>();


    private List<Cart> member_cart_list = new ArrayList<>();

    private List<Reply> member_reply_list = new ArrayList<>();

    public MemberDto(String userid, String password, String name, String nickname) {
        this.userid = userid;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }

    public MemberDto(String password, String name, String nickname) {
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }
}
