package com.example.demo.repositories;

import com.example.demo.entity.TimeSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlotEntity, Long> {

    TimeSlotEntity findByYear(String yearConstant);
}
