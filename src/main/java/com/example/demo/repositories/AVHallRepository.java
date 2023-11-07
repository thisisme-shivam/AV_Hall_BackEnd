package com.example.demo.repositories;

import com.example.demo.entity.AVHallEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AVHallRepository extends JpaRepository<AVHallEntity,Long> {
}
