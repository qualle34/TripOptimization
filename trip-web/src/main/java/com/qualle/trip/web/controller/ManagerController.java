package com.qualle.trip.web.controller;

import com.qualle.trip.web.client.api.Member;
import com.qualle.trip.web.client.api.Trip;
import com.qualle.trip.web.client.api.User;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.qualle.trip.web.controller.handler.AuthenticationUtil.retrieveAuthorities;
import static com.qualle.trip.web.controller.handler.AuthenticationUtil.retrieveUserId;

@Controller
@RequiredArgsConstructor
public class ManagerController {

    private final TripService tripService;
    private final UserService userService;
    private final CountryService countryService;

    @GetMapping("/manager/trips")
    public String getTripsPage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "trips");
        model.addAttribute("trips", tripService.getUserTrips(retrieveUserId(auth)));

        return "tables";
    }

    @GetMapping("/manager/profile")
    public String getProfilePage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("profile", userService.getUser(retrieveUserId(auth)));

        return "profile";
    }

    @GetMapping("/manager/trip/add")
    public String getEditTripPage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "manager-trip-add");

        return "edit";
    }

    @GetMapping("/manager/ticket/add")
    public String getEditTicketPage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "manager-ticket-add");
        model.addAttribute("employees", userService.getUsers());

        return "edit";
    }

    @GetMapping("/manager/member/add")
    public String getEditAllowancePage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "manager-member-add");
        model.addAttribute("trips", tripService.getTrips(0, 100));
        model.addAttribute("employees", userService.getUsers());
        model.addAttribute("countries", countryService.getCountries(0, 100));

        return "edit";
    }

    @PostMapping("/manager/trip/add")
    public String addTrip(Model model, @AuthenticationPrincipal SecurityUser auth, TripDto dto) {
        tripService.saveTrip(dto);

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "member");

        return "edit";
    }

    @PostMapping("/manager/member/add")
    public String addTrip(Model model, @AuthenticationPrincipal SecurityUser auth, MemberDto dto) {
        tripService.saveMember(dto);

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "member");

        return "edit";
    }

    @GetMapping("/manager/trips/{id}/edit")
    public String getEditTripPage(@PathVariable Long id, Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "trip-edit");
        model.addAttribute("trip", tripService.getTrip(id));

        return "edit";
    }
}
