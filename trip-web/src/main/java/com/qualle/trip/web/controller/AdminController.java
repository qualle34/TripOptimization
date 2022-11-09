package com.qualle.trip.web.controller;

import com.qualle.trip.web.service.TripService;
import com.qualle.trip.web.service.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.qualle.trip.web.controller.handler.AuthenticationUtil.retrieveAuthorities;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final TripService tripService;

    @GetMapping( "/admin/trips")
    public String getTripsPage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("trips", tripService.getTrips(0, 5));

        return "trips";
    }

}
