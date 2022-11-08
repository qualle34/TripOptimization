package com.qualle.trip.resurce;

import com.qualle.trip.entity.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TicketResource extends PagingAndSortingRepository<Ticket, Long> {
}