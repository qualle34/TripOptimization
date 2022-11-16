package com.qualle.trip.web.service;

import com.qualle.trip.web.client.api.User;
import com.qualle.trip.web.dto.RegistrationDto;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUser(Long id);

    User getUserWithDepartment(Long id);

    User getUserByLogin(String login);

    void create(RegistrationDto user);

    void update(RegistrationDto user);

    void update(User user);
}
