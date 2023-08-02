package com.micro.raring.services;

import com.micro.raring.entities.Rating;
import com.micro.raring.repositories.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepo repo;

    @Override
    public Rating createRating(Rating rating) {
        return repo.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return  repo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
       return repo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHostelId(String hotelId) {
        return repo.findByHotelId(hotelId);
    }
}
