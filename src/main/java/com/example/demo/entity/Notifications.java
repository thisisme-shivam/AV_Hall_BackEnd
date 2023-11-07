package com.example.demo.entity;

import lombok.Data;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Data
@Table(name="notifications")
@Entity


public class Notifications {
    @Id
    private Long id;
    @Column
    public String name;


}
