package com.qualle.trip.web.controller;

import com.qualle.trip.web.dto.MemberDto;
import com.qualle.trip.web.dto.TripDto;
import com.qualle.trip.web.service.CountryService;
import com.qualle.trip.web.service.TripService;
import com.qualle.trip.web.service.UserService;
import com.qualle.trip.web.service.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static com.qualle.trip.web.controller.handler.AuthenticationUtil.retrieveAuthorities;
import static com.qualle.trip.web.controller.handler.AuthenticationUtil.retrieveUserId;

@Controller
@RequiredArgsConstructor
public class CommonController {

    private final TripService tripService;
    private final UserService userService;
    private final CountryService countryService;

    @PostMapping("/trip/edit/{id}")
    public String addTrip(@PathVariable Long id, Model model, @AuthenticationPrincipal SecurityUser auth, TripDto dto) {

        dto.setId(id);
        tripService.updateTrip(dto);

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "trips");
        model.addAttribute("trips", tripService.getUserTrips(retrieveUserId(auth)));

        return "tables";
    }


}