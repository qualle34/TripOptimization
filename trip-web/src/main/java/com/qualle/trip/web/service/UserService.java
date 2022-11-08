package com.qualle.trip.web.service;

import com.qualle.trip.web.client.api.User;

public interface UserService {

    User getUser(Long id);

    User getUserByLogin(String login);
}
