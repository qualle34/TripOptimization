package com.qualle.trip.web.service;

import com.qualle.trip.web.client.api.Country;
import com.qualle.trip.web.client.api.Ticket;

import java.util.List;

public interface CountryService {

    List<Country> getCountries(int page, int size);

    Country getCountry(long id);
}
