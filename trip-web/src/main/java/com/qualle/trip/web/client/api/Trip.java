package com.qualle.trip.web.client.api;

import lombok.*;

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
    private Date start;
    private Date end;
    private double expenses;
    private List<Member> members;
}
