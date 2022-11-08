package com.qualle.trip.web.controller;

import com.qualle.trip.web.service.HomeService;
import com.qualle.trip.web.service.UserService;
import com.qualle.trip.web.service.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.qualle.trip.web.controller.handler.AuthenticationUtil.retrieveAuthorities;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    private final UserService userService;

    @GetMapping(value = {"/", "/home"})
    public String getHomePage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));

        return "home";
    }

    @GetMapping("/search")
    public String searchPage() {
        return "search";
    }
}