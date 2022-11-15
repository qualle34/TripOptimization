package com.qualle.trip.web.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripDto {

    private Long id;
    private String title;
    private String place;
    private String description;
    private String start;
    private String end;
    private double expenses;
    private long employeeId;
}
