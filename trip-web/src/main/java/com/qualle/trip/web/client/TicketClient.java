package com.qualle.trip.web.client;

import com.qualle.trip.web.client.api.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "ticketClient", url = "http://localhost:8080/")
public interface TicketClient {

    @GetMapping(value = "/tickets?page={page}&size={size}&sort={sort}")
    CollectionModel<Ticket> getTickets(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("sort") String sort);

    @GetMapping(value = "/tickets/{id}")
    EntityModel<Ticket> getTicket(@PathVariable("id") Long id);
}
