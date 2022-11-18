package com.qualle.trip.web.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {

    private Long id;
    private String from;
    private String to;
    private String date;
    private double price;
    private Long typeId;
    private Long employeeId;
    private Long tripId;
}
