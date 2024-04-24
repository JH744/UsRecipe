package com.example.FP.repository;

import com.example.FP.entity.Point;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepositoryCustom {

    List<Point> pointListByUserid(String userid);

    List<Point> usedPointListByUserid(String userid);
    List<Point> addPointListByUserid(String userid);

}
