package com.example.FP.repository;

import com.example.FP.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findByUserid(String userid);
    Member findByEmail(String email);
    Member findByNickname(String nickname);

}
