package com.qualle.trip.web.client.api;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimpleUser {

    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;
    private Gender gender;
}
