package com.micro.raring.services;

import com.micro.raring.entities.Rating;

import java.util.List;

public interface RatingService {
    //create
     Rating createRating(Rating rating);

     List<Rating> getAll();

     List<Rating> getRatingByUserId(String userId);

     List<Rating> getRatingByHostelId(String hotelId);

}
