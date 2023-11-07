package com.example.demo.repositories;

import com.example.demo.entity.BookingEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Long> {
    BookingEntity findBookingEntityByDateAndAndStartTimeAndHallName(Date date, Time startTime,String hallName);
    List<BookingEntity> findBookingEntitiesByUserAndDate(UserEntity user , Date date);

    List<BookingEntity> findBookingEntityByDate(Date date);
}
