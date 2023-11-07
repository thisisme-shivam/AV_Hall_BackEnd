package com.example.demo.beans;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;

@Data
public class BookingBean {
    Long userId;

    Date date;

    String hallName;

    Time startTime;

    Time endTime;


}
