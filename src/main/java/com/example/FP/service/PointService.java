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

    public List<Point> findUsedPointListByUserId(String userid){
        return pr.usedPointListByUserid(userid);
    }

    public List<Point> findGetPointListByUserId(String userid){
        return pr.addPointListByUserid(userid);
    }

    public void savePoint(Point point){
        pr.save(point);
    };
}
