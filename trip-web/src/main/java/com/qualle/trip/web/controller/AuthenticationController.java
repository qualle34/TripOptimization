package com.qualle.trip.web.controller;

import com.qualle.trip.web.service.security.SecurityUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

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

}
