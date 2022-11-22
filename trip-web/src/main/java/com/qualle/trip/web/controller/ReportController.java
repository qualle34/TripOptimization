package com.qualle.trip.web.controller;

import com.qualle.trip.web.client.api.Member;
import com.qualle.trip.web.client.api.Trip;
import com.qualle.trip.web.service.ReportService;
import com.qualle.trip.web.service.TripService;
import com.qualle.trip.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final TripService tripService;
    private final UserService userService;
    private final ReportService reportService;

    @GetMapping("/report/{tripId}")
    public ResponseEntity<Resource> download(@PathVariable Long tripId) throws IOException {

        Trip trip = tripService.getFullTrip(tripId);

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
