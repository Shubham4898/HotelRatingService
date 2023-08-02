package com.micro.raring.repositories;

import com.micro.raring.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends MongoRepository<Rating,String> {

    //custom methods

    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
