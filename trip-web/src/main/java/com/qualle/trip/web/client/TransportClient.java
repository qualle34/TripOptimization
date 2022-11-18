package com.qualle.trip.web.client;

import com.qualle.trip.web.client.api.Transport;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "transportClient", url = "http://localhost:8080/")
public interface TransportClient {

    @GetMapping(value = "/transports")
    CollectionModel<Transport> getTransports();
}