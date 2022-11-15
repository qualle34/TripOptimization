package com.qualle.trip.web.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {

    private String login;
    private String name;
    private String surname;
    private String patronymic;
    private String birthday;
    private String gender;
    private String email;
    private String phone;
    private String password;
}
