package com.example.FP.repository;

import com.example.FP.entity.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long>,MemberRepositoryCustom{

    Member findByUserid(String userid);
    Member findByEmail(String email);
    Member findByNickname(String nickname);

    Member findByNameAndEmail(String name, String email);

    Member findByUseridAndEmail(String userid, String email);

    @Modifying()
    @Query("UPDATE Member m SET m.password= :password WHERE m.userid= :userid")
    int updatePwd(@Param("password") String password,@Param("userid") String userid);

}
