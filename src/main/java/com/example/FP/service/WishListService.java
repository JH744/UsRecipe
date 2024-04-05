package com.example.FP.service;

import com.example.FP.entity.WishList;
import com.example.FP.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final WishListRepository wr;

    public List<WishList> findAllWishList(String userid){
        return wr.findByUserid(userid);
    }
}
