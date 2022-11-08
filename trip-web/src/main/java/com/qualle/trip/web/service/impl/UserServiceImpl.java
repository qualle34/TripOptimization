package com.qualle.trip.web.service.impl;

import com.qualle.trip.web.client.UserClient;
import com.qualle.trip.web.client.api.User;
import com.qualle.trip.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserClient userClient;

    @Override
    public User getUser(Long id) {
        return userClient.getUser(id).getContent();
    }

    @Override
    public User getUserByLogin(String login) {
        return userClient.getUserByLogin(login).getContent();
    }
}
