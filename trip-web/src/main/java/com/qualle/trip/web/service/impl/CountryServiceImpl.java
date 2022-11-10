package com.qualle.trip.web.service.impl;

import com.qualle.trip.web.client.CountryClient;
import com.qualle.trip.web.client.api.Country;
import com.qualle.trip.web.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryClient countryClient;

    @Override
    public List<Country> getCountries(int page, int size) {
        return new ArrayList<>(countryClient.getCountries(page, size, "").getContent());
    }

    @Override
    public Country getCountry(long id) {
        return countryClient.getCountry(id).getContent();
    }
}
