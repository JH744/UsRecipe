package com.example.FP.repository;

import com.example.FP.entity.QWishList;
import com.example.FP.entity.WishList;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.FP.entity.QWishList.wishList;


@Repository
public class WishListRepositoryImpl implements WishListRepositoryCustom{

    private final JPAQueryFactory queryFactory;


    public WishListRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);

    }

    //유저아이디별 찜목록을 가져오기 위한 메소드 구현
    @Override
    public List<WishList> findByUserid(String userid) {
        List<WishList> list = queryFactory.selectFrom(wishList).where(wishList.wishlistMember.userid.eq(userid)).fetch();
        return list;
    }
}
