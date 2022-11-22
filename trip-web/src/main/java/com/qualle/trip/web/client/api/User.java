package com.qualle.trip.web.client.api;

import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;
    private Credentials credentials;
    private Department department;
    private List<Contact> contacts;
    private List<Member> members;
    private Role role;
    private Gender gender;
}
