package com.example.FP.dto;

import com.example.FP.entity.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class MemberDto {

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

    private MemberRole role;



    private List<Inquiry> inquiry_list = new ArrayList<>();

    private List<WishList> wishlist_list = new ArrayList<>();


    private List<Recipe> recipe_list = new ArrayList<>();


    private List<OrderDetails> order_member_list = new ArrayList<>();


    private List<Cart> member_cart_list = new ArrayList<>();

    private List<Reply> member_reply_list = new ArrayList<>();

    private List<Alarm> member_alarm_list = new ArrayList<>();
    private List<Point> member_point_list= new ArrayList<>();
    private List<Orders> member_orders_list = new ArrayList<>();


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

    public MemberDto(String userid, String password, String name, String nickname, String addr, String email, String phone, Integer point, String birth,List<Point> member_point_list) {
        this.userid = userid;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.addr = addr;
        this.email = email;
        this.phone = phone;
        this.point = point;
        this.birth = birth;
        this.role=MemberRole.MEMBER;
        this.member_point_list = member_point_list;
    }

    public MemberDto(String userid, String password, String name, String nickname, String email, String phone) {
        this.userid = userid;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.phone = phone;
    }

    public MemberDto(Member m){
        this.userid = m.getUserid();
        this.password = m.getPassword();
        this.name = m.getName();
        this.nickname = m.getNickname();
        this.email = m.getEmail();
        this.phone = m.getPhone();
        this.addr = m.getAddr();
        this.role = m.getRole();
    }

    public MemberDto() {}
}
