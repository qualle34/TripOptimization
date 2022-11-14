package com.qualle.trip.web.controller;

import com.qualle.trip.web.dto.RegistrationDto;
import com.qualle.trip.web.service.UserService;
import com.qualle.trip.web.service.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @GetMapping(value = "/login")
    public String getLoginPage(@AuthenticationPrincipal SecurityUser user) {
        if (user != null) {
            return "redirect:/home";
        }
        return "login";
    }

    @GetMapping(value = "/registration")
    public String getRegistrationPage(@AuthenticationPrincipal SecurityUser user) {
        if (user != null) {
            return "redirect:/home";
        }
        return "registration";
    }

    @PostMapping(value = "/registration")
    public void doRegistration(RegistrationDto dto) {
        userService.create(dto);
    }
}
