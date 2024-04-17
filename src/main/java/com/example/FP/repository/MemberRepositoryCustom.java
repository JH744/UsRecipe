package com.example.FP.repository;

import com.example.FP.entity.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepositoryCustom {
    //정보변경 전 비밀번호 확인을 위한 메소드
    String findPasswordById(String userid);

    Member findNamePointOrderCntByUserid(String userid);
    Member findByUserid(String userid);
}
