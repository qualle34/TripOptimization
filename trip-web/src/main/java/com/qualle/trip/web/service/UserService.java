package com.qualle.trip.web.service;

import com.qualle.trip.web.client.api.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUser(Long id);

    User getUserByLogin(String login);
}
