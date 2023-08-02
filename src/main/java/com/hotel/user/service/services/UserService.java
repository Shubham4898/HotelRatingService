package com.hotel.user.service.services;

import com.hotel.user.service.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUser();

    User getUser(String userId);

    //todo :- update user or delete user
}
