package com.qualle.trip.web.client;

import com.qualle.trip.web.client.api.Member;
import com.qualle.trip.web.client.api.Trip;
import com.qualle.trip.web.client.api.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "tripClient", url = "http://localhost:8080/")
public interface TripClient {

    @GetMapping(value = "/trips?page={page}&size={size}&sort={sort}")
    CollectionModel<Trip> getTrips(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("sort") String sort);

    @GetMapping(value = "/trips/search/findByUserId?userId={userId}")
    CollectionModel<Trip> getTripsByUserId(@PathVariable("userId") Long userId);

    @GetMapping(value = "/trips/{id}")
    EntityModel<Trip> getTrip(@PathVariable("id") Long id);

    @GetMapping(value = "/members/search/findMemberByUserAndTrip?userId={userId}&tripId={tripId}")
    EntityModel<Member> getMemberByUserAndTrip(@PathVariable("userId") Long userId, @PathVariable("tripId") Long tripId);

    @GetMapping(value = "/members/search/findMembersByTrip?tripId={tripId}")
    CollectionModel<Member> getMembersByTrip(@PathVariable("tripId") Long tripId);

    @GetMapping(value = "/members/{id}")
    EntityModel<Member> getMember(@PathVariable("id") Long id);

    @PostMapping(value = "/trips")
    EntityModel<Trip> saveTrip(Trip trip);

    @PutMapping(value = "/trips/{id}")
    EntityModel<Trip> updateTrip(@PathVariable("id") Long id, Trip trip);

    @PostMapping(value = "/members")
    EntityModel<Member> saveMember(Member member);

    @PatchMapping(value = "/members/{id}")
    EntityModel<Member> updateMember(@PathVariable("id") Long id, Member member);
}
