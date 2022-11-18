package com.qualle.trip.web.controller;

import com.qualle.trip.web.service.*;
import com.qualle.trip.web.service.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.qualle.trip.web.controller.handler.AuthenticationUtil.retrieveAuthorities;
import static com.qualle.trip.web.controller.handler.AuthenticationUtil.retrieveUserId;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final TripService tripService;
    private final UserService userService;

    @GetMapping("/user/trips")
    public String getTripsPage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "trips");
        model.addAttribute("trips", tripService.getUserTrips(retrieveUserId(auth)));

        return "tables";
    }

    @GetMapping("/user/profile")
    public String getProfilePage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("profile", userService.getUserWithDepartment(retrieveUserId(auth)));

        return "profile";
    }

    @GetMapping("/user/trips/{id}/edit")
    public String getEditTripPage(@PathVariable Long id, Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "trip-edit");
        model.addAttribute("trip", tripService.getTrip(id));

        return "edit";
    }

    @GetMapping("/user/profile/edit")
    public String getEditProfilePage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "null");
        model.addAttribute("user", userService.getUserWithDepartment(retrieveUserId(auth)));

        return "edit";
    }
}