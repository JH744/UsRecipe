package com.example.FP.service;

import com.example.FP.details.PrincipalDetails;
import com.example.FP.dto.MemberDto;
import com.example.FP.entity.Member;
import com.example.FP.entity.Recipe;
import com.example.FP.mapper.MemberMapper;
import com.example.FP.repository.MemberRepository;
import com.example.FP.repository.RecipeRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberService implements UserDetailsService {
    private final MemberRepository mr;
    private final RecipeRepository rr;

    // 존재하는 회원인지 확인
    public void validateDuplicateMember(Member member) {
        Member findMember = mr.findByUserid(member.getUserid());
        if (findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    public Long join(Member member){
        validateDuplicateMember(member);
        System.out.println("맴버 서비스");
        mr.save(member);
        return member.getId();
    }
    public void dataChange(Member member){
        mr.save(member);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername 실행");
        Member m = mr.findByUserid(username);
        if (m == null) {
            throw new UsernameNotFoundException(username);
        }
        return new PrincipalDetails(m);
    }

    public Member findById(String userid){
        return mr.findByUserid(userid);
    }

    public void save(Member m){
        mr.save(m);
    }

    public String pwCheck(String userid){
        String passwordById = mr.findPasswordById(userid);
        System.out.println(passwordById);

        return passwordById;
    }

    public Boolean findByUserid(String userid){
        Member byUserid = mr.findByUserid(userid);
        if (byUserid != null) {
            if (byUserid.getUserid() == null) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public Boolean findByEmail(String email){
        Member byEmail = mr.findByEmail(email);
        if (byEmail != null) {
            if (byEmail.getEmail() == null) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public Boolean findByNickname(String nickname){
        Member byNickname = mr.findByNickname(nickname);
        if (byNickname != null) {
            if (byNickname.getNickname() == null) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    //로그인 한 회원의 정보를 가져옴
    public Member findByUseridInfo(String userid){
        Member member = mr.findByUserid(userid);
        return member;
    }

    public HashMap<String, String> findByNameAndEmail(String name, String email){
        HashMap<String, String> map = new HashMap<>();
        Member m = mr.findByNameAndEmail(name, email);
        if (m != null) {
            if (m.getUserid() == null) {
                map.put("success", "false");
                return map;
            } else {
                map.put("success", "true");
                map.put("userid", m.getUserid());
                return map;
            }
        }
        return map;
    }

    public Boolean findByUseridAndEmail(String userid, String email){
        Member m = mr.findByUseridAndEmail(userid, email);
        if (m != null) {
            if (m.getUserid() == null) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public Member listPointAndNameByUserid(String userid){
        return mr.findNamePointOrderCntByUserid(userid);
    }

    public List<Member> findAllMember(){
        return mr.findAll();
    }

    public void deleteMember(Long id) {
        mr.deleteById(id);
    }
    // 조회수 높은 상위 5명
    public List<Member> findTop5(){
        List<Member> list;
        List<Member> ids = rr.findMember();
        ArrayList<Long> arr_id = new ArrayList<>();
        for (int i = 0; ids.size() > i; i++) {
            arr_id.add(ids.get(i).getId());
        }
        System.out.println(arr_id);
        list = mr.findByIdIn(arr_id);

        return list;
    }

}
