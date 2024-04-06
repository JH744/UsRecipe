package com.example.FP.repository;

import com.example.FP.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long>,MemberRepositoryCustom{

    Member findByUserid(String userid);

}
