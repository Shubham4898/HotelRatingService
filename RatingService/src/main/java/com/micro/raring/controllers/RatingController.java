package com.micro.raring.controllers;

import com.micro.raring.entities.Rating;
import com.micro.raring.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService service;
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createRating(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAll(){

        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return ResponseEntity.ok(service.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(service.getRatingByHostelId(hotelId));
    }

}
