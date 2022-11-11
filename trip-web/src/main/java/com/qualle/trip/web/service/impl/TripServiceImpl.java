package com.qualle.trip.web.service.impl;

import com.qualle.trip.web.client.TripClient;
import com.qualle.trip.web.client.api.Trip;
import com.qualle.trip.web.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripClient tripClient;


    @Override
    public List<Trip> getTrips(int page, int size) {
        return getTrips(page, size, "");
    }

    @Override
    public List<Trip> getTrips(int page, int size, String sort) {

        CollectionModel<Trip> trips = tripClient.getTrips(page, size, sort);

        return new ArrayList<>(trips.getContent());
    }

    @Override
    public List<Trip> getUserTrips(long userId) {

        CollectionModel<Trip> trips = tripClient.getTripsByUserId(userId);

        return new ArrayList<>(trips.getContent());
    }

    @Override
    public Trip getTrip(Long id) {
        return tripClient.getTrip(id).getContent();
    }
}
