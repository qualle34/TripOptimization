package com.qualle.trip.web.client;

import com.qualle.trip.web.client.api.Country;
import com.qualle.trip.web.client.api.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "countryClient", url = "http://localhost:8080/")
public interface CountryClient {

    @GetMapping(value = "/countries?page={page}&size={size}&sort={sort}")
    CollectionModel<Country> getCountries(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("sort") String sort);

    @GetMapping(value = "/countries/{id}")
    EntityModel<Country> getCountry(@PathVariable("id") Long id);
}

