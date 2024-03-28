package com.example.FP.repository;

import com.example.FP.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;



public interface WishListRepository extends JpaRepository<WishList,Long> {
}
