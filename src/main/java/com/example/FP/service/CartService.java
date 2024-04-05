package com.example.FP.service;

import com.example.FP.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    @Autowired
    private final CartRepository cp;



//    public List<Cart> cartList(long id){
//
//    }






}
