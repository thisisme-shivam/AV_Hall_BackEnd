package com.example.demo.service;

import com.example.demo.entity.BookingEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repositories.BookingRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserService userService;

    public BookingEntity save(Long userId, Date date, Time startTime, Time endTime, String hallName) {
        BookingEntity bookingEntity = new BookingEntity();

        BookingEntity alreadyBooked = bookingRepository.findBookingEntityByDateAndAndStartTimeAndHallName(date, startTime, hallName);
        if(alreadyBooked!=null){
            return null;
        }
        bookingEntity.setDate(date);
        bookingEntity.setEndTime(endTime);
        bookingEntity.setStartTime(startTime);
        bookingEntity.setHallName(hallName);
        UserEntity user = userService.findUserById(userId);
        bookingEntity.setUser(user);
        bookingRepository.save(bookingEntity);
        return bookingEntity;
    }

    public List<BookingEntity> findReportsByUserIdAndDate(Date date, Long userId) {
        UserEntity  userEntity  = userService.findUserById(userId);

        return bookingRepository.findBookingEntitiesByUserAndDate(userEntity,date);
    }

    public List<BookingEntity> findReportsByDate(Date date) {
        return bookingRepository.findBookingEntityByDate(date);
    }
}
