package com.qualle.trip.web.service;

import com.qualle.trip.web.client.api.Ticket;
import com.qualle.trip.web.dto.TicketDto;

import java.util.List;

public interface TicketService {

    List<Ticket> getTickets(int page, int size);

    Ticket getTicket(long id);

    void addTicket(TicketDto dto);
}
