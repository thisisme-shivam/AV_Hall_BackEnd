package com.example.demo.entity;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Setter
@Data

public class UserEntity {
    @Id
    @Column
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String phone;



}
