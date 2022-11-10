package com.qualle.trip.web.client.api;

import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private Long id;
    private String name;
    private String description;
    private List<User> users;
}
