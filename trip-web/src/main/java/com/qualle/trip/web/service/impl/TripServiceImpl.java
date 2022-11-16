package com.qualle.trip.web.service.impl;

import com.qualle.trip.web.client.TripClient;
import com.qualle.trip.web.client.api.*;
import com.qualle.trip.web.dto.MemberDto;
import com.qualle.trip.web.dto.TripDto;
import com.qualle.trip.web.service.TripService;
import com.qualle.trip.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripClient tripClient;
    private final UserService userService;


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

    @Override
    public void saveTrip(TripDto dto) {

        Trip trip = Trip.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .place(dto.getPlace())
                .description(dto.getDescription())
                .start(LocalDate.parse(dto.getStart()))
                .end(LocalDate.parse(dto.getEnd()))
                .expenses(dto.getExpenses())
                .build();

        tripClient.saveTrip(trip);
    }

    @Override
    public void updateTrip(TripDto dto) {

        Trip trip = Trip.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .place(dto.getPlace())
                .description(dto.getDescription())
                .start(LocalDate.parse(dto.getStart()))
                .end(LocalDate.parse(dto.getEnd()))
                .expenses(dto.getExpenses())
                .build();

        tripClient.updateTrip(dto.getId(), trip);
    }

    @Override
    public void saveMember(MemberDto dto) {
        User user = userService.getUser(dto.getEmployeeId());

        Member member = Member.builder()
                .role(dto.getRole())
                .user(User.builder().id(dto.getEmployeeId()).build())
                .trip(Trip.builder().id(dto.getTripId()).build())
//                .memberAllowances(List.of(MemberAllowance.builder()
//                        .allowance(Allowance.builder()
//                                .country(Country.builder()
//                                        .id(dto.getCountryId()).build())
//                                .value(dto.getExpenses())
//                                .build())
//                        .days(dto.getDays())
//                        .build()))
                .build();


        List<Member> members = user.getMembers() == null ? new ArrayList<>() : user.getMembers();

        members.add(member);
        user.setMembers(members);

        userService.update(user);
    }
}
