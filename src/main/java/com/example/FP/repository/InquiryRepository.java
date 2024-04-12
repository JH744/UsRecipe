package com.example.FP.repository;

import com.example.FP.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry,Long> ,InquiryRepositoryCustom{


}
