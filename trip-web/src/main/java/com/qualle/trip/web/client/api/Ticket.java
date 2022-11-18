package com.qualle.trip.web.client.api;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    private Long id;
    private String from;
    private String to;
    private LocalDate date;
    private double price;
    private Transport type;
    private Member member;
}
