package com.example.demo.service;


import com.example.demo.entity.AVHallEntity;
import com.example.demo.repositories.AVHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AVHallService {
    @Autowired
    AVHallRepository avHallRepository;

    public List<AVHallEntity> getAVhalls() {
        List<AVHallEntity> avHalls = avHallRepository.findAll();
        return avHalls;
    }

    public AVHallEntity save(AVHallEntity avHallEntity) {
        avHallRepository.save(avHallEntity);
        return  avHallEntity;
    }
}
