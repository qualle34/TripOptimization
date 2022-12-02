package com.qualle.trip.web.controller;

import com.qualle.trip.web.client.api.Member;
import com.qualle.trip.web.client.api.Trip;
import com.qualle.trip.web.dto.CreateReportDto;
import com.qualle.trip.web.service.ReportService;
import com.qualle.trip.web.service.TripService;
import com.qualle.trip.web.service.UserService;
import com.qualle.trip.web.service.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static com.qualle.trip.web.controller.handler.AuthenticationUtil.retrieveAuthorities;

@Controller
@RequiredArgsConstructor
public class ReportController {

    private final TripService tripService;
    private final UserService userService;
    private final ReportService reportService;

    @GetMapping("/admin/report")
    public String download(Model model, @AuthenticationPrincipal SecurityUser auth) {

        model.addAttribute("authorities", retrieveAuthorities(auth));
        model.addAttribute("type", "report");
        model.addAttribute("trips", tripService.getTrips(0, 40));
        return "edit";
    }

    @PostMapping("/admin/report/create")
    public ResponseEntity<Resource> download(CreateReportDto dto) throws IOException {

        Trip trip = tripService.getFullTrip(dto.getTripId());

        File file = reportService.makeReport(trip);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.docx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
