package com.qualle.trip.web.service.impl;

import com.qualle.trip.web.client.TicketClient;
import com.qualle.trip.web.client.api.Ticket;
import com.qualle.trip.web.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketClient ticketClient;

    @Override
    public List<Ticket> getTickets(int page, int size) {
        return new ArrayList<>(ticketClient.getTickets(page, size, "").getContent());
    }

    @Override
    public Ticket getTicket(long id) {
        return ticketClient.getTicket(id).getContent();
    }
}
