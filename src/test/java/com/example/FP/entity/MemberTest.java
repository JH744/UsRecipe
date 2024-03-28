package com.example.FP.entity;

import com.example.FP.dto.MemberDto;
import com.example.FP.mapper.MemberMapper;
import com.example.FP.repository.MemberRepository;
import jakarta.validation.Valid;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberTest {

    @Autowired
    private MemberRepository mr;


    @Test
    public void dtoTest(){



    }

}