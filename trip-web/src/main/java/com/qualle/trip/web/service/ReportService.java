package com.qualle.trip.web.service;

import com.qualle.trip.web.client.api.Trip;

import java.io.File;

public interface ReportService {

    File makeReport(Trip trip);
}
