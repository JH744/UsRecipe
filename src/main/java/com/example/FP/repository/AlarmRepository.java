package com.example.FP.repository;

import com.example.FP.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlarmRepository extends JpaRepository<Alarm, Long> {
}
