package com.qualle.trip.web.service;

import com.qualle.trip.web.client.api.Trip;

import java.util.List;

public interface TripService {

    List<Trip> getTrips(int page, int size);

    List<Trip> getTrips(int page, int size, String sort);

    Trip getTrip(Long id);
}
