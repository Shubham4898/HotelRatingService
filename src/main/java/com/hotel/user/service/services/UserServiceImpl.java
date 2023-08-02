package com.hotel.user.service.services;

import com.hotel.user.service.eceptions.ResourceNotFoundException;
import com.hotel.user.service.entities.Hotel;
import com.hotel.user.service.entities.Rating;
import com.hotel.user.service.entities.User;
import com.hotel.user.service.externalServices.HotelService;
import com.hotel.user.service.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
       String id =  UUID.randomUUID().toString();
       user.setUserId(id);
        return repo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return repo.findAll();
    }

    @Override
    public User getUser(String userId) {

        User user =  repo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id not found -" + userId));

        Rating[]  ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(),Rating[].class);

        List<Rating> ratingList =    Arrays.stream(ratings).toList();
        List<Rating> ratingHotel =  ratingList.stream().map(rating -> {
//           ResponseEntity<Hotel> responseEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId() , Hotel.class);
           Hotel hotel = hotelService.getHotel(rating.getHotelId());
           rating.setHotel(hotel);
           return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingHotel);
        logger.info(""+ ratings);
        return user;

    }
}
