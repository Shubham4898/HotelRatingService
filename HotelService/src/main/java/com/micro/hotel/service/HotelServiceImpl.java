package com.micro.hotel.service;

import com.micro.hotel.entities.Hotel;
import com.micro.hotel.exceptions.ResourceNotFoundException;
import com.micro.hotel.respositories.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements  HotelService{

    @Autowired
    private HotelRepo repo;
    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        System.out.println(hotel);
        return repo.save(hotel);
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return repo.findById(hotelId).orElseThrow(
                () -> new ResourceNotFoundException("hotel with give id not found" + hotelId));

    }

    @Override
    public List<Hotel> getAll() {
        return  repo.findAll();
    }
}
