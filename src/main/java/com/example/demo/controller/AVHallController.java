package com.example.demo.controller;

import com.example.demo.entity.AVHallEntity;
import com.example.demo.service.AVHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/avhalls")
public class AVHallController {
    @Autowired
    AVHallService avHallService;

    @GetMapping
    public ResponseEntity<List<AVHallEntity>> getAVHall(){
        List<AVHallEntity> avHalls = avHallService.getAVhalls();
        if(avHalls == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(avHalls);
    }


    @PostMapping
    public ResponseEntity<Long> addAVHall(@RequestBody AVHallEntity avHall){
        avHall.setId(null);
        AVHallEntity avHallEntity = avHallService.save(avHall);

        if(avHallEntity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return  ResponseEntity.ok(avHallEntity.getId());
    }

}
