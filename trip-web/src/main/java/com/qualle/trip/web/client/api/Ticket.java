package com.qualle.trip.web.client.api;

import lombok.*;

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
    private Date date;
    private double price;
    private Transport type;
    private Member member;
}
