package com.example.FP.service;

import com.example.FP.entity.Point;
import com.example.FP.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository pr;

    public List<Point> findPointListByUserid(String userid){
        return pr.pointListByUserid(userid);

    }
}
