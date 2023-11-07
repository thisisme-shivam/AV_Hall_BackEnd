package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "timeslots")
@Data
public class TimeSlotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    Time startTime;

    @Column
    Time endTime;

    @Column
    Time lunchTime;

    @Column
    String year;
}
