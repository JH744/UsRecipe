//
//package com.example.FP.entity;
//
//import com.example.FP.dto.MemberDto;
//import com.example.FP.mapper.MemberMapper;
//import com.example.FP.repository.MemberRepository;
//import com.example.FP.repository.PointRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//@Rollback(value = false)
//class MemberTest {
//    private final MemberRepository mr;
//    private final PointRepository pr;
//
//    @Autowired
//    public MemberTest(MemberRepository mr, PointRepository pr) {
//        this.mr = mr;
//        this.pr = pr;
//    }
//
//        @Test
//    public void joinMember() {
//        MemberDto member4 = new MemberDto("aaa","aaa","aaa","aaa","aaa","aaa@naver.com","010-1111-2222",0,"1997-03-24",null);
//        MemberDto member5 = new MemberDto("bbb","bbb","bbb","bbb","bbb","bbb@naver.com","010-3333-4444",0,"1997-03-25",null);
//        MemberDto member6 = new MemberDto("ccc","ccc","ccc","ccc","ccc","ccc@naver.com","010-5555-6666",0,"1997-03-25",null);
//        Member member1 = MemberMapper.toEntity(member4);
//        Member member2 = MemberMapper.toEntity(member5);
//        Member member3 = MemberMapper.toEntity(member6);
//        mr.save(member1);
//        mr.save(member2);
//        mr.save(member3);
//
//        System.out.println("member1.getPoint() = " + member1.getPoint());
//
//        System.out.println(member1.getRole());
//        assertThat(member1.getName()).isEqualTo("aaa");
//          assertThat(member1.getPoint()).isEqualTo(0);
//    }
//
////    @Test
////    public void passwordCheck(){
////        MemberDto member4 = new MemberDto("ddd","aaa","aaa","aaa","aaa","aaa@naver.com","010-1111-2222",0,"1997-03-24",null);
////        Member member1 = MemberMapper.toEntity(member4);
////        mr.save(member1);
////
////        String passwordById = mr.findPasswordById(member1.getUserid());
////
////        assertThat(passwordById).isEqualTo("aaa");
////
////    }
//
////    @Test
////    public void pointTest() throws Exception{
////        //given
////        MemberDto member4 = new MemberDto("aaa","aaa","aaa","aaa","aaa","aaa@naver.com","010-1111-2222",0,"1997-03-24",null);
//////        MemberDto member5 = new MemberDto("bbb","bbb","bbb","bbb","bbb","bbb@naver.com","010-3333-4444",0,"1997-03-25",null);
////        MemberDto member6 = new MemberDto("ccc","ccc","ccc","ccc","ccc","ccc@naver.com","010-5555-6666",0,"1997-03-25",null);
////        Member member1 = MemberMapper.toEntity(member4);
//////        Member member2 = MemberMapper.toEntity(member5);
////        Member member3 = MemberMapper.toEntity(member6);
////        mr.save(member1);
//////        mr.save(member2);
////        mr.save(member3);
////
////        //when
////        Point point = new Point(100,"구매에 의한 포인트 적립",member1,null);
////        pr.save(point);
////
////
////        //then
////        List<Point> list = pr.pointListByUserid("aaa");
////
////        for (Point points : list) {
////            int usePoint = points.getUse_point();
////            assertThat(usePoint).isEqualTo(100);
////
////        }
////
////
////    }
//}
//
