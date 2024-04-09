package com.example.FP.repository;

import com.example.FP.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point,Long>,PointRepositoryCustom {
}
