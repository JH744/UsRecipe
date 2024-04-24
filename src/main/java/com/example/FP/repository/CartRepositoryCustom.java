package com.example.FP.repository;

import com.example.FP.entity.Cart;

import java.util.List;

public interface CartRepositoryCustom {

    List<Cart> findByUserid(String userid);
}
