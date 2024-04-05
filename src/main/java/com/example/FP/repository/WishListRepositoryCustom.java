package com.example.FP.repository;

import com.example.FP.entity.WishList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepositoryCustom {
    public List<WishList> findByUserid(String userid);
}
