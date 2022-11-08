package com.qualle.trip.web.service.impl;

import com.qualle.trip.web.client.UserClient;
import com.qualle.trip.web.client.api.User;
import com.qualle.trip.web.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final UserClient userClient;

    @Override
    public User getUserById(Long id) {
        return userClient.getUser(id).getContent();
    }
}
