package com.qualle.trip.web.controller;

import com.qualle.trip.web.service.*;
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
    private final UserService userService;
    private final DepartmentService departmentService;
    private final CountryService countryService;
    private final TicketService ticketService;

    @GetMapping( "/admin/trips")
    public String getTripsPage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("trips", tripService.getTrips(0, 5));

        return "trips";
    }

    @GetMapping( "/admin/employees")
    public String getEmployeesPage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("employees", userService.getUsers());

        return "employees";
    }

    @GetMapping( "/admin/departments")
    public String getDepartmentsPage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("departments", departmentService.getDepartments(0, 5));

        return "departments";
    }

    @GetMapping( "/admin/countries")
    public String getCountriesPage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("countries", countryService.getCountries(0, 5));

        return "countries";
    }

    @GetMapping( "/admin/tickets")
    public String getTicketsPage(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("tickets", ticketService.getTickets(0, 5));

        return "tickets";
    }

}
