package com.example.demo.entity;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "avhalls")
@Data
public class AVHallEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;
}
