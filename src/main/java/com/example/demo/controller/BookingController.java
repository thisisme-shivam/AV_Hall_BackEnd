package com.example.demo.controller;


import com.example.demo.beans.BookingBean;
import com.example.demo.beans.UserReportBean;
import com.example.demo.entity.BookingEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.BookingService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    UserService userService;
    @PostMapping
    public ResponseEntity<Long> bookAvHall(@RequestBody BookingBean bookingBean){
        BookingEntity bookingEntity = bookingService.save(bookingBean.getUserId(),
                bookingBean.getDate(),bookingBean.getStartTime(),bookingBean.getEndTime(),bookingBean.getHallName());

        if(bookingEntity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return new ResponseEntity<>(bookingEntity.getId(),HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<List<BookingEntity>> getBookingsByUserId(@RequestBody UserReportBean userReportBean){
        List<BookingEntity>  userBookings = bookingService.findReportsByUserIdAndDate(userReportBean.getDate(),userReportBean.getUserId());
        if(userBookings == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return new ResponseEntity<>(userBookings,HttpStatus.OK);
    }


    @PostMapping("/all")
    public ResponseEntity<List<BookingEntity>> getBookingsByDate(@RequestBody Map<String,String> req){
        List<BookingEntity>  userBookings = bookingService.findReportsByDate(Date.valueOf(req.get("date")));
        if(userBookings == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return new ResponseEntity<>(userBookings,HttpStatus.OK);
    }

}
