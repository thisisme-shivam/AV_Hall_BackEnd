package com.example.demo.controller;

import com.example.demo.entity.TimeSlotEntity;
import com.example.demo.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeslot")
public class TimeSlotController {
    @Autowired
    TimeSlotService timeSlotService;

    @PostMapping
    public ResponseEntity<Long> createTimeSlot(@RequestBody TimeSlotEntity timeSlot) {

        TimeSlotEntity savedTimeSlot = timeSlotService.save(timeSlot);
        if (savedTimeSlot == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(savedTimeSlot.getId());
    }

    @GetMapping
    public ResponseEntity<List<TimeSlotEntity>> getTimeSlots() {
        List<TimeSlotEntity> timeslots = timeSlotService.findAll();

        if(timeslots == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(timeslots);
    }

    @GetMapping("/{year}")
    public ResponseEntity<List<TimeSlotEntity>> getTimeSlotsByYear(@PathVariable String year){
        List<TimeSlotEntity> timeSlots  = timeSlotService.getTimeslots(year);
        if(timeSlots == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(timeSlots);
    }

}
