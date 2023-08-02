package com.micro.hotel.controllers;

import com.micro.hotel.entities.Hotel;
import com.micro.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService service;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody  Hotel hotel){
        System.out.println(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createHotel(hotel));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id){
           return ResponseEntity.status(HttpStatus.OK).body(service.getHotel(id));
    }


    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }


}
