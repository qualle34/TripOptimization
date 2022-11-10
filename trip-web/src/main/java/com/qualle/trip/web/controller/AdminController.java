package com.qualle.trip.web.controller;

import com.qualle.trip.web.service.*;
import com.qualle.trip.web.service.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.qualle.trip.web.controller.handler.AuthenticationUtil.retrieveAuthorities;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final TripService tripService;
    private final UserService userService;
    private final DepartmentService departmentService;
    private final CountryService countryService;
    private final TicketService ticketService;

    @GetMapping("/admin/trips")
    public String getTripsPage(@RequestParam(required = false) Integer page, Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "trips");
        model.addAttribute("trips", tripService.getTrips(clarifyPage(page), 2));

        return "admin";
    }

    @GetMapping("/admin/employees")
    public String getEmployeesPage(@RequestParam(required = false) Integer page, Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "employees");
        model.addAttribute("employees", userService.getUsers());

        return "admin";
    }

    @GetMapping("/admin/departments")
    public String getDepartmentsPage(@RequestParam(required = false) Integer page, Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "departments");
        model.addAttribute("departments", departmentService.getDepartments(clarifyPage(page), 5));

        return "admin";
    }

    @GetMapping("/admin/countries")
    public String getCountriesPage(@RequestParam(required = false) Integer page, Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "countries");
        model.addAttribute("countries", countryService.getCountries(clarifyPage(page), 5));

        return "admin";
    }

    @GetMapping("/admin/tickets")
    public String getTicketsPage(@RequestParam(required = false) Integer page, Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "tickets");
        model.addAttribute("tickets", ticketService.getTickets(clarifyPage(page), 5));

        return "admin";
    }

    private int clarifyPage(Integer page) {
        if (page == null) {
            return 0;
        }
        if (page <= 0) {
            return 0;
        }
        return page;
    }

}
