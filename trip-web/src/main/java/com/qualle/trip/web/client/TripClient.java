package com.qualle.trip.web.client;

import com.qualle.trip.web.client.api.Trip;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "tripClient", url = "http://localhost:8080/")
public interface TripClient {

    @GetMapping(value = "/trips?page={page}&size={size}&sort={sort}")
    CollectionModel<Trip> getTrips(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("sort") String sort);

    @GetMapping(value = "/trips/{id}")
    EntityModel<Trip> getTrip(@PathVariable("id") Long id);

}
