package com.micro.hotel.service;


import com.micro.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create
     Hotel createHotel(Hotel hotel);

    //getHotel

    Hotel getHotel(String hotelId);

    //getAll

    List<Hotel> getAll();
}
