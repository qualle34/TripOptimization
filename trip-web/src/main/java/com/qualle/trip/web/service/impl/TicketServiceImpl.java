package com.qualle.trip.web.service.impl;

import com.qualle.trip.web.client.TicketClient;
import com.qualle.trip.web.client.api.Member;
import com.qualle.trip.web.client.api.Ticket;
import com.qualle.trip.web.client.api.Transport;
import com.qualle.trip.web.client.api.User;
import com.qualle.trip.web.dto.TicketDto;
import com.qualle.trip.web.service.TicketService;
import com.qualle.trip.web.service.TripService;
import com.qualle.trip.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketClient ticketClient;
    private final TripService tripService;

    @Override
    public List<Ticket> getTickets(int page, int size) {
        return new ArrayList<>(ticketClient.getTickets(page, size, "").getContent());
    }

    @Override
    public Ticket getTicket(long id) {
        return ticketClient.getTicket(id).getContent();
    }

    @Override
    public void addTicket(TicketDto dto) {

        Member member = tripService.getMemberByUserAndTrip(dto.getEmployeeId(), dto.getTripId());

        Ticket ticket = Ticket.builder()
                .from(dto.getFrom())
                .to(dto.getTo())
                .date(LocalDate.parse(dto.getDate()))
                .price(dto.getPrice())
                .type(Transport.builder().id(dto.getTypeId()).build())
                .member(Member.builder().id(member.getId()).build())
                .build();

        ticketClient.addTicket(ticket);
    }
}
