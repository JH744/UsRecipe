package com.example.FP.repository;

import com.example.FP.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long>,MemberRepositoryCustom{

    Member findByUserid(String userid);
    Member findByEmail(String email);
    Member findByNickname(String nickname);

    Member findByNameAndEmail(String name, String email);

    Member findByUseridAndEmail(String userid, String email);

    @Modifying
    @Query(name = "update member set password=:password where userid=:userid", nativeQuery = true)
    Member updatePwd(String password, String userid);
}
