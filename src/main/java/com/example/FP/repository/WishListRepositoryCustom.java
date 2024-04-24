package com.example.FP.repository;

import com.example.FP.entity.WishList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepositoryCustom {

    //유저아이디별 찜목록을 가져오기 위한 메소드
    public List<WishList> findByUserid(String userid);
}
