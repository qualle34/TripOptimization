package com.qualle.trip.web.controller;

import com.qualle.trip.web.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping(value = {"/", "/home"})
    public String getHomePage(Model model, @AuthenticationPrincipal UserDetails auth) {
        model.addAttribute("authorities", auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        return "home";
    }

    @GetMapping("/search")
    public String searchPage(){
        return "search";
    }
}