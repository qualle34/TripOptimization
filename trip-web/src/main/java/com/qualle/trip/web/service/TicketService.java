package com.qualle.trip.web.service;

import com.qualle.trip.web.client.api.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> getTickets(int page, int size);

    Ticket getTicket(long id);
}
