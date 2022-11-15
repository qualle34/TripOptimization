package com.qualle.trip.web.client.api;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

    private Long id;
    private String title;
    private String place;
    private String description;
    private LocalDate start;
    private LocalDate end;
    private double expenses;
    private List<Member> members;
}
