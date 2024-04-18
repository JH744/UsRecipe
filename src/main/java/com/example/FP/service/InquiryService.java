package com.example.FP.service;

import com.example.FP.entity.Inquiry;
import com.example.FP.repository.InquiryRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class InquiryService {

    private final InquiryRepository ir;

    public List<Inquiry> findByUserid(String userid){
        return ir.listByUserid(userid);
    }


    public Optional<Inquiry> findById(Long id) {
        return ir.findById(id);
    }


    public List<Inquiry> answered(){return ir.listInquiryAnswered();}
    public List<Inquiry> answeredYet(){return ir.listInquiryAnswerYet();}
    public void save(Inquiry inquiry){ir.save(inquiry);}


    public Inquiry listById(Long id){

        return ir.findById(id).get();
    }

    public void deleteInquiry(Long id){
        ir.deleteById(id);
    }

    public void updateInquiry(Long id){

        ir.updateInquiry(id);

    }

    public List<Inquiry> findAll(){
        return ir.findAll();
    }

}
