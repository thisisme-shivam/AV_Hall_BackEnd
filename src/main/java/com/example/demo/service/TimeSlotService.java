package com.example.demo.service;


import com.example.demo.entity.TimeSlotEntity;
import com.example.demo.repositories.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class TimeSlotService {
    @Autowired
    TimeSlotRepository timeSlotRepository;
    public List<TimeSlotEntity> getTimeslots(String year) {
        TimeSlotEntity timeslot = timeSlotRepository.findByYear(year);
        List<TimeSlotEntity> timeSlots = new ArrayList<>();

        Time startTime = timeslot.getStartTime();
        Time endTime = timeslot.getEndTime();
        Time lunchTime = timeslot.getLunchTime();

        // Initialize a calendar with the start time
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);

        // Iterate until the lunch time
        while (calendar.getTime().before(lunchTime)) {
            TimeSlotEntity timeSlot = new TimeSlotEntity();
            timeSlot.setStartTime(new Time(calendar.getTime().getTime()));

            // Add 1 hour
            calendar.add(Calendar.HOUR, 1);

            timeSlot.setEndTime(new Time(calendar.getTime().getTime()));
            timeSlots.add(timeSlot);
        }

        // Add 35 minutes to the lunch time and use it as the start time for the next time slots
        calendar.setTime(lunchTime);
        calendar.add(Calendar.MINUTE, 35);

        // Continue adding time slots until the end time
        while (calendar.getTime().before(endTime)) {
            TimeSlotEntity timeSlot = new TimeSlotEntity();
            timeSlot.setStartTime(new Time(calendar.getTime().getTime()));

            // Add 35 minutes
            calendar.add(Calendar.HOUR, 1);

            timeSlot.setEndTime(new Time(calendar.getTime().getTime()));
            timeSlots.add(timeSlot);
        }

        return timeSlots;
    }


    public TimeSlotEntity save(TimeSlotEntity newTimeSlotEntity) {

        TimeSlotEntity previousTimeSlot  = timeSlotRepository.findByYear(newTimeSlotEntity.getYear());
        if(previousTimeSlot == null){
            timeSlotRepository.save(newTimeSlotEntity);
            return newTimeSlotEntity;
        }
        previousTimeSlot.setEndTime(newTimeSlotEntity.getEndTime());
        previousTimeSlot.setLunchTime(newTimeSlotEntity.getLunchTime());
        previousTimeSlot.setStartTime(newTimeSlotEntity.getStartTime());

        timeSlotRepository.save(previousTimeSlot);
        return previousTimeSlot;

    }

    public List<TimeSlotEntity> findAll() {
        return timeSlotRepository.findAll();
    }
}
