package com.qualle.trip.web.client.api;

import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transport {

    private Long id;
    private String value;
    private List<Ticket> tickets;
}
