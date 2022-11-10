package com.qualle.trip.web.client;

import com.qualle.trip.web.client.api.Trip;
import com.qualle.trip.web.client.api.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "userClient", url = "http://localhost:8080/")
public interface UserClient {

    @GetMapping(value = "/users?page={page}&size={size}&sort={sort}")
    CollectionModel<User> getUsers(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("sort") String sort);

    @GetMapping(value = "/users/{id}")
    EntityModel<User> getUser(@PathVariable("id") Long id);

    @GetMapping(value = "/users/search/findUserByLogin?login={login}")
    EntityModel<User> getUserByLogin(@PathVariable("login") String login);
}