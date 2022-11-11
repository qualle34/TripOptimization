package com.qualle.trip.web.controller;

import com.qualle.trip.web.service.*;
import com.qualle.trip.web.service.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.qualle.trip.web.controller.handler.AuthenticationUtil.retrieveAuthorities;
import static com.qualle.trip.web.controller.handler.AuthenticationUtil.retrieveUserId;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final TripService tripService;
    private final UserService userService;

    @GetMapping("/trips")
    public String getTripsPage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "trips");
        model.addAttribute("trips", tripService.getUserTrips(retrieveUserId(auth)));

        return "data";
    }

    @GetMapping("/profile")
    public String getProfilePage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("profile", userService.getUser(retrieveUserId(auth)));

        return "profile";
    }
}