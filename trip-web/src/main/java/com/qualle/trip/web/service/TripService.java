package com.qualle.trip.web.service;

import com.qualle.trip.web.client.api.Member;
import com.qualle.trip.web.client.api.Trip;
import com.qualle.trip.web.dto.MemberDto;
import com.qualle.trip.web.dto.TripDto;

import java.util.List;

public interface TripService {

    List<Trip> getTrips(int page, int size);

    List<Trip> getTrips(int page, int size, String sort);

    List<Trip> getUserTrips(long userId);

    Trip getTrip(Long id);

    Trip getFullTrip(Long id);

    Member getMemberByUserAndTrip(Long userId, Long tripId);

    Member getMember(Long id);

    void saveTrip(TripDto dto);

    void updateTrip(TripDto dto);

    void saveMember(MemberDto dto);
}
