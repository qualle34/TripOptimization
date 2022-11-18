package com.qualle.trip.event;

import com.qualle.trip.entity.Allowance;
import com.qualle.trip.entity.Ticket;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RepositoryEventHandler
public class TicketEventHandler {

    @HandleBeforeCreate
    public void handleTicketCreate(Ticket ticket) {
        if (ticket.getMember() != null) {
            ticket.getMember().setTickets(List.of(ticket));
        }
    }

    @HandleBeforeSave
    public void handleTicketSave(Ticket ticket) {
        if (ticket.getMember() != null) {
            ticket.getMember().setTickets(List.of(ticket));
        }
        if (ticket.getType() != null) {
            ticket.getType().setTickets(List.of(ticket));
        }
    }
}